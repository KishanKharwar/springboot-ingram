package com.oauth2.springoauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RIVTController {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/rivt")
  public String testRIVTApi(){
    //RestTemplate restTemplate = new RestTemplate();
    String uri = "https://wsgx.cisco.com/wwchannels/services/external/getData";

    String requestString = "{\n"
        + "    \"service\": \"getRessellerData\",\n"
        + "    \"ccoId\": \"IMDISTI\",\n"
        + "    \"profileId\": \"3\",\n"
        + "    \"entity\": [{\n"
        + "        \"sourceName\": \"INGRAM MICRO\",\n"
        + "        \"theaterCode\": \"USA\",\n"
        + "        \"country\": \"USA\",\n"
        + "        \"pageNumber\": 2,\n"
        + "        \"pageSize\": 10\n"
        + "    }]\n"
        + "}";




    HttpHeaders h = new HttpHeaders();

    h.setBasicAuth("disti_services.gen","disti_gen");
    h.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> entity = new HttpEntity<>(requestString,h);
    System.out.println(entity);
    ResponseEntity<String> response = restTemplate.exchange(uri,HttpMethod.POST, entity, String.class);
    System.out.println(response);
    return response.getBody();
  }

  @GetMapping("/orderStatus")
  public String testOrderStatusApi(){
    String access_token_url = "https://cloudsso.cisco.com/as/token.oauth2?client_id=bfhh8sfzeqpz6ymyzqkg4rba&client_secret=N6RU8bHeA5nP3nSn65nQHfM5&grant_type=client_credentials";

    ResponseEntity<String> accessToken = restTemplate
    .exchange(access_token_url, HttpMethod.POST, null, String.class);

    System.out.println(accessToken.getBody());

    return accessToken.getBody();
  }

}
