package com.talkup.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @GetMapping
    public ResponseEntity<?> getAllGroups() {
        // Mock implementation to return all groups
        List<Map<String, Object>> groups = Arrays.asList(
            Map.of(
                "id", "1",
                "name", "Beginner English",
                "description", "Group for beginners learning English",
                "createdBy", "3" // Admin user
            ),
            Map.of(
                "id", "2",
                "name", "Intermediate English",
                "description", "Group for intermediate English learners",
                "createdBy", "3" // Admin user
            ),
            Map.of(
                "id", "3",
                "name", "Advanced English",
                "description", "Group for advanced English learners",
                "createdBy", "3" // Admin user
            )
        );
        
        return ResponseEntity.ok(groups);
    }
    
    @PostMapping
    public ResponseEntity<?> createGroup(@RequestBody Map<String, Object> groupRequest) {
        // Mock implementation to create a group
        Map<String, Object> newGroup = new HashMap<>(groupRequest);
        newGroup.put("id", "4");
        
        return ResponseEntity.ok(newGroup);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getGroupById(@PathVariable String id) {
        // Mock implementation to return a group by ID
        Map<String, Object> group = Map.of(
            "id", id,
            "name", "Beginner English",
            "description", "Group for beginners learning English",
            "createdBy", "3" // Admin user
        );
        
        return ResponseEntity.ok(group);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable String id, @RequestBody Map<String, Object> groupUpdate) {
        // Mock implementation to update a group
        Map<String, Object> updatedGroup = new HashMap<>(groupUpdate);
        updatedGroup.put("id", id);
        
        return ResponseEntity.ok(updatedGroup);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable String id) {
        // Mock implementation to delete a group
        Map<String, String> response = Map.of(
            "message", "Group with ID " + id + " deleted successfully"
        );
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}/members")
    public ResponseEntity<?> getGroupMembers(@PathVariable String id) {
        // Mock implementation to return group members
        List<Map<String, Object>> members = Arrays.asList(
            Map.of(
                "id", "1",
                "email", "student1@example.com",
                "firstName", "John",
                "lastName", "Doe",
                "role", "GROUP_STUDENT",
                "joinedAt", "2025-04-01T10:00:00Z"
            ),
            Map.of(
                "id", "4",
                "email", "student2@example.com",
                "firstName", "Jane",
                "lastName", "Doe",
                "role", "GROUP_STUDENT",
                "joinedAt", "2025-04-02T11:30:00Z"
            )
        );
        
        return ResponseEntity.ok(members);
    }
    
    @PostMapping("/{id}/members")
    public ResponseEntity<?> addGroupMember(@PathVariable String id, @RequestBody Map<String, Object> memberRequest) {
        // Mock implementation to add a member to a group
        String userId = (String) memberRequest.get("userId");
        
        Map<String, Object> response = Map.of(
            "groupId", id,
            "userId", userId,
            "joinedAt", "2025-04-25T12:00:00Z"
        );
        
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{groupId}/members/{userId}")
    public ResponseEntity<?> removeGroupMember(@PathVariable String groupId, @PathVariable String userId) {
        // Mock implementation to remove a member from a group
        Map<String, String> response = Map.of(
            "message", "User with ID " + userId + " removed from group with ID " + groupId + " successfully"
        );
        
        return ResponseEntity.ok(response);
    }
}