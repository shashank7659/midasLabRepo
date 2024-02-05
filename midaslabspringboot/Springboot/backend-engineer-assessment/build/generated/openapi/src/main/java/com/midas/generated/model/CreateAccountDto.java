package com.midas.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CreateAccountDto
 */

@JsonTypeName("createAccount")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T00:44:31.750692+05:30[Asia/Calcutta]")
public class CreateAccountDto {

  private String firstName;

  private String lastName;

  private String email;

  public CreateAccountDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * User's first name
   * @return firstName
  */
  
  @Schema(name = "firstName", example = "John", description = "User's first name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CreateAccountDto lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * User's last name
   * @return lastName
  */
  
  @Schema(name = "lastName", example = "Doe", description = "User's last name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CreateAccountDto email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email of user
   * @return email
  */
  
  @Schema(name = "email", example = "john@doe.com", description = "Email of user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateAccountDto createAccount = (CreateAccountDto) o;
    return Objects.equals(this.firstName, createAccount.firstName) &&
        Objects.equals(this.lastName, createAccount.lastName) &&
        Objects.equals(this.email, createAccount.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAccountDto {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

