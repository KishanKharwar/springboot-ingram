package com.oauth2.springoauth.beans;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Item {
	private String ID;
	private String Description;
	private Lot Lot;
}
