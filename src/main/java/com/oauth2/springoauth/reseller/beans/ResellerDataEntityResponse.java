package com.oauth2.springoauth.reseller.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResellerDataEntityResponse {
  private String country;
  private String distiValSoldTo;
  private String registrationStatus;
  private String website;
  private String regEffectiveStartDate;
  private String partnerName;
  private String address2;
  private String city;
  private String address1;
  private String postalCode;
  private String certEffectiveStartDate;
  private String partnerSiteID;
  private String certification;
  private String authorization;
  private String registrationExpiryDate;
  private String certificationExpiryDate;
  private String phoneNumber;
  private String partnerNameBeGeoName;
  private String specialization;
  private String state;
  private String partnerType;
  private String distiValRid;
}
