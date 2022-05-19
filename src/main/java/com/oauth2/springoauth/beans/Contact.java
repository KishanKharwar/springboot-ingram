package com.oauth2.springoauth.beans;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Contact {
	private PersonName PersonName;
	private List<TelephoneCommunication> TelephoneCommunication;
	private EMailAddressCommunication EMailAddressCommunication;
}
