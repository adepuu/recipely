package com.adepuu.recipely.users.service.impl;

import com.adepuu.recipely.users.dto.RegisterPayload;
import com.adepuu.recipely.users.entity.User;
import com.adepuu.recipely.users.service.UserSvc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserSvcImpl implements UserSvc {
  List<User> users = new ArrayList<>();

  @Override
  public User getCurrentUser() {
    User user = new User();
    user.setId(new UUID(0, 0));
    user.setFirstName("Adepoju");
    user.setLastName("Oluwaseun");
    user.setEmail("adepuu@mail.com");
    user.setMsisdn("+2348100000000");
    return user;
  }

  @Override
  public User registerUser(RegisterPayload registerPayload) {
    User user = registerPayload.toEntity();

    // This one will be replaced by a JPA repository
    users.forEach(u -> {
      if (u.getEmail().equals(user.getEmail())) {
        throw new RuntimeException("User with this email already exists");
      }
      if (u.getMsisdn().equals(user.getMsisdn())) {
        throw new RuntimeException("Phone number already registered");
      }
    });

    user.setId(UUID.randomUUID());
    users.add(user);
    return user;
  }

  @Override
  public User getPublicUserProfile(UUID id) {
    for (User user : users) {
      if (user.getId().equals(id)) {
        return user;
      }
    }
    throw new RuntimeException("User not found");
  }

  @Override
  public User getUserByEmail(String email) {
    return null;
  }


}
