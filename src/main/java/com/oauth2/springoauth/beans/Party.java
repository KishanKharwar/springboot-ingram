package com.oauth2.springoauth.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Party {
	private String Name;
	private Location Location;
	private Contact Contact;
	private String typeCode;
	private String text;
}
