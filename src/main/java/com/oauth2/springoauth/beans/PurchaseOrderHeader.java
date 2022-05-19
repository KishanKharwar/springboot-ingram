package com.oauth2.springoauth.beans;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseOrderHeader {
	private String ID;
	private ArrayList<Object> documentReference = new ArrayList<Object>();
	private Status statusObject;
	private Party partyObject;
	private ShipToParty ShipToPartyObject;
	private TotalAmount TotalAmountObject;
	private BillToParty BillToPartyObject;
	private String OrderDateTime;
	private SalesOrderReference SalesOrderReferenceObject;
	private ArrayList<Object> Extension = new ArrayList<Object>();

}
