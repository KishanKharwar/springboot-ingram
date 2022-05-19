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

public class Extension {
	private Name Name;
	private Date DateTime;
	private String typeCode;
	private Date text;
}
