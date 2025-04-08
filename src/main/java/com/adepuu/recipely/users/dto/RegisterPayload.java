package com.adepuu.recipely.users.dto;

import com.adepuu.recipely.users.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterPayload {
  @NotNull(message = "First name is required")
  private String firstName;

  private String lastName;

  @NotNull(message = "MSISDN is required")
  @Min(value = 11, message = "MSISDN must be at least 11 digits")
  private String msisdn;

  @Email(message = "Email should be valid")
  @NotNull(message = "Email is required")
  private String email;

  @NotNull(message = "Password is required")
  @Min(value = 6, message = "Password must be at least 6 characters")
  private String password;

  public User toEntity() {
    User user = new User();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setMsisdn(msisdn);
    user.setEmail(email);
    user.setPassword(password);
    return user;
  }
}
