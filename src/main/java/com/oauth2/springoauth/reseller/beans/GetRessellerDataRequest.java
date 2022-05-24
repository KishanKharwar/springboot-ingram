package com.oauth2.springoauth.reseller.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetRessellerDataRequest {
  private String service;
  private String profileId;
  private String ccoId;
  private List<ResellerDataEntityRequest> entity;
}
