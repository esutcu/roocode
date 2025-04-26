package com.talkup.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserAvailability(@PathVariable String userId) {
        // Mock implementation to return user availability
        List<Map<String, Object>> availability = Arrays.asList(
            Map.of(
                "id", "1",
                "userId", userId,
                "dayOfWeek", 2, // Tuesday
                "timeSlotId", 3 // 14-17
            ),
            Map.of(
                "id", "2",
                "userId", userId,
                "dayOfWeek", 4, // Thursday
                "timeSlotId", 3 // 14-17
            )
        );
        
        return ResponseEntity.ok(availability);
    }
    
    @PostMapping
    public ResponseEntity<?> createAvailability(@RequestBody Map<String, Object> availabilityRequest) {
        // Mock implementation to create availability
        Map<String, Object> newAvailability = new HashMap<>(availabilityRequest);
        newAvailability.put("id", "3");
        
        return ResponseEntity.ok(newAvailability);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAvailability(@PathVariable String id, @RequestBody Map<String, Object> availabilityUpdate) {
        // Mock implementation to update availability
        Map<String, Object> updatedAvailability = new HashMap<>(availabilityUpdate);
        updatedAvailability.put("id", id);
        
        return ResponseEntity.ok(updatedAvailability);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAvailability(@PathVariable String id) {
        // Mock implementation to delete availability
        Map<String, String> response = Map.of(
            "message", "Availability with ID " + id + " deleted successfully"
        );
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/time-slots")
    public ResponseEntity<?> getTimeSlots() {
        // Mock implementation to return time slots
        List<Map<String, Object>> timeSlots = Arrays.asList(
            Map.of(
                "id", 1,
                "startTime", "08:00",
                "endTime", "11:00",
                "name", "8-11"
            ),
            Map.of(
                "id", 2,
                "startTime", "11:00",
                "endTime", "14:00",
                "name", "11-14"
            ),
            Map.of(
                "id", 3,
                "startTime", "14:00",
                "endTime", "17:00",
                "name", "14-17"
            ),
            Map.of(
                "id", 4,
                "startTime", "17:00",
                "endTime", "20:00",
                "name", "17-20"
            ),
            Map.of(
                "id", 5,
                "startTime", "20:00",
                "endTime", "22:00",
                "name", "20-22"
            )
        );
        
        return ResponseEntity.ok(timeSlots);
    }
}