package com.oauth2.springoauth.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Status {
	private String Description;
	private String Code;
	private Extension Extension;
	private EffectiveTimePeriod EffectiveTimePeriod;
}
