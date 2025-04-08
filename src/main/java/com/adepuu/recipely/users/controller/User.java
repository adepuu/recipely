package com.adepuu.recipely.users.controller;

import com.adepuu.recipely.users.dto.RegisterPayload;
import com.adepuu.recipely.users.service.UserSvc;
import com.adepuu.recipely.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class User {
  private final UserSvc userSvc;

  public User(UserSvc userSvc) {
    this.userSvc = userSvc;
  }

  @GetMapping
  public ResponseEntity<?> getCurrentUser() {
    return Response.successfulResponse("Hello from user controller", userSvc.getCurrentUser());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getPublicUserProfile(@PathVariable String id) {
    UUID userId = UUID.fromString(id);
    return Response.successfulResponse("User profile retrieved successfully", userSvc.getPublicUserProfile(userId));
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody RegisterPayload user) {
    return Response.successfulResponse("User registered successfully", userSvc.registerUser(user));
  }
}
