package com.oauth2.springoauth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.oauth2.springoauth.beans.OrderStatusAccessToken;
import com.oauth2.springoauth.reseller.beans.GetRessellerDataRequest;
import com.oauth2.springoauth.reseller.beans.GetRessellerDataResponse;
import com.oauth2.springoauth.reseller.beans.ResellerDataEntityRequest;

@RestController
@PropertySource("classpath:config.properties")
public class RIVTController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${rivt.api.url}")
	private String apiUrl;
	@Value("${rivt.api.basic.auth.username}")
	private String username;
	@Value("${rivt.api.basic.auth.password}")
	private String password;
	

	@GetMapping("/rivt")
	@Retryable(HttpServerErrorException.class)
	public String testRIVTApi() {
//		// RestTemplate restTemplate = new RestTemplate();
//		//String uri = "https://wsgx.cisco.com/wwchannels/services/external/getData";
//
//		String requestString = "{\n" + "    \"service\": \"getRessellerData\",\n" + "    \"ccoId\": \"IMDISTI\",\n"
//				+ "    \"profileId\": \"3\",\n" + "    \"entity\": [{\n" + "        \"sourceName\": \"INGRAM MICRO\",\n"
//				+ "        \"theaterCode\": \"USA\",\n" + "        \"country\": \"USA\",\n"
//				+ "        \"pageNumber\": 2,\n" + "        \"pageSize\": 100\n" + "    }]\n" + "}";

		HttpHeaders h = new HttpHeaders();
		
		String s = createJsonRequest();
		System.out.println("Request in sting : " + s);
		
		
		h.setBasicAuth(username, password);
		h.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<>(s, h);
		System.out.println(entity);
		ResponseEntity<GetRessellerDataResponse> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, GetRessellerDataResponse.class);
		System.out.println(response);
		return response.getBody().toString();
	}

	private String createJsonRequest() {
		
		ResellerDataEntityRequest entity = new ResellerDataEntityRequest("USA","1","USA","100","INGRAM MICRO");
		List<ResellerDataEntityRequest> entityList = new ArrayList<>();
		entityList.add(entity);
		GetRessellerDataRequest request = new GetRessellerDataRequest("getRessellerData","3","IMDISTI",entityList);
		String json = new Gson().toJson(request);
		return json;
	}

}
