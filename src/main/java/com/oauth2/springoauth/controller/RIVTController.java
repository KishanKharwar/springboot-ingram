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
		HttpHeaders h = null;
		String request = null;
		HttpEntity<String> entity = null;
		ResponseEntity<GetRessellerDataResponse> response = null;
		String totalItems = "";
		int noOfRequests = 0;

		request = createJsonRequest("1", "100");
		System.out.println("Request in sting : " + request);

		h = new HttpHeaders();
		h.setBasicAuth(username, password);
		h.setContentType(MediaType.APPLICATION_JSON);

		entity = new HttpEntity<>(request, h);
		response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, GetRessellerDataResponse.class);

		totalItems = response.getBody().getTotalItems();

		if (Integer.valueOf(totalItems) > 100) {
			noOfRequests = Integer.valueOf(totalItems) + 1;

			for (int i = 2; i <= noOfRequests; i++) {
				request = createJsonRequest("" + i, "100");
				entity = new HttpEntity<>(request, h);
				response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, GetRessellerDataResponse.class);
			}
		}

		return response.getBody().toString();
	}

	/**
	 * It creates the string json request to call reseller api with specific pageNumber and pageSize
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	private String createJsonRequest(String pageNumber, String pageSize) {
		ResellerDataEntityRequest entity = new ResellerDataEntityRequest("USA", pageNumber, "USA", pageSize,
				"INGRAM MICRO");
		List<ResellerDataEntityRequest> entityList = new ArrayList<>();
		entityList.add(entity);
		GetRessellerDataRequest request = new GetRessellerDataRequest("getRessellerData", "3", "IMDISTI", entityList);
		String json = new Gson().toJson(request);
		return json;
	}

}
