package com.midas.app.models;

public class User {
  // Other fields...

  public enum ProviderType {
    STRIPE
  }

  private ProviderType providerType;
  private String providerId;

  // Getters and setters...
}
