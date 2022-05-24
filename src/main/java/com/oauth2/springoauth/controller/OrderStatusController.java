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

import com.oauth2.springoauth.beans.OrderStatusAccessToken;

@RestController
public class OrderStatusController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/orderStatus")
	public String testOrderStatusApi() {

		OrderStatusAccessToken accessToken = getAccessToken();

		String uri = "https://api.cisco.com/commerce/ORDER/v2/sync/checkOrderStatus";
		String request = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<GetPurchaseOrder xmlns=\"http://www.openapplications.org/oagis/10\">\r\n" + 
				"<ApplicationArea>\r\n" + 
				"    <CreationDateTime>2017-1-5T06:03:35-00:00</CreationDateTime>\r\n" + 
				"     <BODID>test123456712a</BODID>        \r\n" + 
				"     </ApplicationArea>\r\n" + 
				"<DataArea>\r\n" + 
				"    <PurchaseOrder>\r\n" + 
				"        <PurchaseOrderHeader>\r\n" + 
				"                <ID>70DZC90D</ID>\r\n" + 
				"            <DocumentReference>\r\n" + 
				"                <ID></ID>\r\n" + 
				"            </DocumentReference>\r\n" + 
				"            <SalesOrderReference>\r\n" + 
				"                <ID></ID>\r\n" + 
				"            </SalesOrderReference>\r\n" + 
				"            <Description typeCode=\"details\">Yes</Description>\r\n" + 
				"        </PurchaseOrderHeader>\r\n" + 
				"    </PurchaseOrder>\r\n" + 
				"</DataArea>\r\n" + 
				"</GetPurchaseOrder>\r\n" + 
				"";
		HttpHeaders h = new HttpHeaders();

		h.setBearerAuth(accessToken.getAccess_token());;
		h.setContentType(MediaType.APPLICATION_XML);
		
		HttpEntity<String> requestEntity = new HttpEntity<>(request,h);
		
		ResponseEntity<String> response = restTemplate.exchange(uri,HttpMethod.POST,requestEntity,String.class);
		System.out.println(response.getBody());
		return response.getBody().toString();
	}

	private OrderStatusAccessToken getAccessToken() {
		String access_token_url = "https://cloudsso.cisco.com/as/token.oauth2?client_id=bfhh8sfzeqpz6ymyzqkg4rba&client_secret=N6RU8bHeA5nP3nSn65nQHfM5&grant_type=client_credentials";

		ResponseEntity<OrderStatusAccessToken> accessToken = restTemplate.exchange(access_token_url, HttpMethod.POST,
				null, OrderStatusAccessToken.class);

		System.out.println(accessToken.getBody());
		return accessToken.getBody();
	}
}
