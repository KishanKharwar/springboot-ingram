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
public class EffectiveTimePeriod {
	private Date StartDateTime;
	private Date EndDateTime;
}
