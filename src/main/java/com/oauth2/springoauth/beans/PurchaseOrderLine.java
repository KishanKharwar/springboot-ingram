package com.oauth2.springoauth.beans;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseOrderLine {
	private Status Status;
	private Item Item;
	private ExtendedAmount ExtendedAmount;
	private ContractReference ContractReference;
	private SalesOrderReference SalesOrderReference;
	private String LineNumberID;
	private LineIDSet LineIDSet;
	private Description Description;
	private Date PromisedDeliveryDateTime;
	private ShipFromParty ShipFromParty;
}
