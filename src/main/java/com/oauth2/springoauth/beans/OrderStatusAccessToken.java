package com.oauth2.springoauth.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderStatusAccessToken {
	private String access_token;
	private String token_type;
	private float expires_in;
}
