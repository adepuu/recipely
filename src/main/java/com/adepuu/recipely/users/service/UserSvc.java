package com.adepuu.recipely.users.service;

import com.adepuu.recipely.users.dto.RegisterPayload;
import com.adepuu.recipely.users.entity.User;

import java.util.UUID;

public interface UserSvc {
  User getCurrentUser();
  User getPublicUserProfile(UUID id);
  User registerUser(RegisterPayload registerPayload);
}
