package com.talkup.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserBookings(@PathVariable String userId) {
        // Mock implementation to return user bookings
        List<Map<String, Object>> bookings = Arrays.asList(
            Map.of(
                "id", "1",
                "studentId", userId,
                "teacherId", "2",
                "dayOfWeek", 2, // Tuesday
                "timeSlotId", 3, // 14-17
                "status", "SCHEDULED",
                "meetingLink", "https://meet.google.com/abc-defg-hij",
                "creditsUsed", 1,
                "bookingDate", "2025-05-01"
            ),
            Map.of(
                "id", "2",
                "studentId", userId,
                "teacherId", "2",
                "dayOfWeek", 4, // Thursday
                "timeSlotId", 3, // 14-17
                "status", "SCHEDULED",
                "meetingLink", "https://meet.google.com/klm-nopq-rst",
                "creditsUsed", 1,
                "bookingDate", "2025-05-03"
            )
        );
        
        return ResponseEntity.ok(bookings);
    }
    
    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Map<String, Object> bookingRequest) {
        // Mock implementation to create a booking
        Map<String, Object> newBooking = new HashMap<>(bookingRequest);
        newBooking.put("id", "3");
        newBooking.put("status", "SCHEDULED");
        newBooking.put("meetingLink", "https://meet.google.com/uvw-xyz-123");
        
        return ResponseEntity.ok(newBooking);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable String id, @RequestBody Map<String, Object> bookingUpdate) {
        // Mock implementation to update a booking
        Map<String, Object> updatedBooking = new HashMap<>(bookingUpdate);
        updatedBooking.put("id", id);
        
        return ResponseEntity.ok(updatedBooking);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable String id) {
        // Mock implementation to cancel a booking
        Map<String, String> response = Map.of(
            "message", "Booking with ID " + id + " cancelled successfully"
        );
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/calendar/{userId}")
    public ResponseEntity<?> getUserCalendar(@PathVariable String userId) {
        // Mock implementation to return user calendar
        List<Map<String, Object>> calendar = Arrays.asList(
            Map.of(
                "date", "2025-05-01",
                "dayOfWeek", 2, // Tuesday
                "timeSlot", "14:00 - 17:00",
                "teacher", "Jane Smith",
                "status", "SCHEDULED"
            ),
            Map.of(
                "date", "2025-05-03",
                "dayOfWeek", 4, // Thursday
                "timeSlot", "14:00 - 17:00",
                "teacher", "Jane Smith",
                "status", "SCHEDULED"
            )
        );
        
        return ResponseEntity.ok(calendar);
    }
}