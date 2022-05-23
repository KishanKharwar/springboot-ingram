package com.oauth2.springoauth.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetRessellerDataResponse {
  private String totalItems;
  private String success;
  private String errorFlag;
  private String message;
  private ResellerDataEntityResponse[][] entity;
  private String statusCode;
}
