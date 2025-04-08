package com.adepuu.recipely.users.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private UUID id;
  private String firstName;
  private String lastName;
  private String msisdn;
  private String email;
  private String password;
}
