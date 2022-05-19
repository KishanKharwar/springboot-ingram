package com.oauth2.springoauth.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
	private AddressLine AddressLine;
	private String CityName;
	private String CountrySubDivisionCode;
	private String CountryCode;
	private int PostalCode;
}
