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
public class PurchaseOrder {
	private PurchaseOrderHeader PurchaseOrderHeaderObject;
	private ArrayList<Object> PurchaseOrderLine = new ArrayList<Object>();
}
