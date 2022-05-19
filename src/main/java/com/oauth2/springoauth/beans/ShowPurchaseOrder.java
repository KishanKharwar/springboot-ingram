package com.oauth2.springoauth.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShowPurchaseOrder {
	private ApplicationArea ApplicationAreaObject;
	private DataArea DataAreaObject;
	private String xmlns;
	private String xmlns_ns2;
}
