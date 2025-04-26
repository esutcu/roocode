package com.talkup.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        // Mock implementation to return all users
        List<Map<String, Object>> users = Arrays.asList(
            Map.of(
                "id", "1",
                "email", "student@example.com",
                "firstName", "John",
                "lastName", "Doe",
                "role", "INDIVIDUAL_STUDENT",
                "credits", 100
            ),
            Map.of(
                "id", "2",
                "email", "teacher@example.com",
                "firstName", "Jane",
                "lastName", "Smith",
                "role", "TEACHER",
                "credits", 0
            ),
            Map.of(
                "id", "3",
                "email", "admin@example.com",
                "firstName", "Admin",
                "lastName", "User",
                "role", "ADMIN",
                "credits", 0
            )
        );
        
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        // Mock implementation to return a user by ID
        Map<String, Object> user = Map.of(
            "id", id,
            "email", "student@example.com",
            "firstName", "John",
            "lastName", "Doe",
            "role", "INDIVIDUAL_STUDENT",
            "credits", 100
        );
        
        return ResponseEntity.ok(user);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody Map<String, Object> userUpdate) {
        // Mock implementation to update a user
        Map<String, Object> updatedUser = new HashMap<>(userUpdate);
        updatedUser.put("id", id);
        
        return ResponseEntity.ok(updatedUser);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        // Mock implementation to delete a user
        Map<String, String> response = Map.of(
            "message", "User with ID " + id + " deleted successfully"
        );
        
        return ResponseEntity.ok(response);
    }
}