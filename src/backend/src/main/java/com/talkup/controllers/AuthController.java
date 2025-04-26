package com.talkup.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        // Mock login implementation
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        
        // In a real application, you would validate credentials against the database
        // and generate a JWT token
        
        Map<String, Object> response = new HashMap<>();
        response.put("token", "mock-jwt-token");
        response.put("user", Map.of(
            "id", "1",
            "email", email,
            "firstName", "John",
            "lastName", "Doe",
            "role", "INDIVIDUAL_STUDENT",
            "credits", 100
        ));
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> registerRequest) {
        // Mock registration implementation
        String email = registerRequest.get("email");
        String password = registerRequest.get("password");
        String firstName = registerRequest.get("firstName");
        String lastName = registerRequest.get("lastName");
        String role = registerRequest.get("role");
        
        // In a real application, you would save the user to the database
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User registered successfully");
        response.put("user", Map.of(
            "id", "1",
            "email", email,
            "firstName", firstName,
            "lastName", lastName,
            "role", role,
            "credits", 0
        ));
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken() {
        // Mock refresh token implementation
        Map<String, Object> response = new HashMap<>();
        response.put("token", "new-mock-jwt-token");
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> forgotPasswordRequest) {
        // Mock forgot password implementation
        String email = forgotPasswordRequest.get("email");
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Password reset email sent to " + email);
        
        return ResponseEntity.ok(response);
    }
}