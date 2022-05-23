package com.oauth2.springoauth.beans;

import java.util.List;

public class GetRessellerDataRequest {
  private String service;
  private String profileId;
  private String ccoId;
  private List<ResellerDataEntityRequest> entity;
}
