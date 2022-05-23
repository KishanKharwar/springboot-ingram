package com.oauth2.springoauth.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResellerDataEntityRequest {
  private String country;
  private String pageNumber;
  private String theaterCode;
  private String pageSize;
  private String sourceName;
}
