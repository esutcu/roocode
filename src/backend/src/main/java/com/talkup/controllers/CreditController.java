package com.talkup.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/credits")
public class CreditController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserCredits(@PathVariable String userId) {
        // Mock implementation to return user credits
        Map<String, Object> credits = Map.of(
            "userId", userId,
            "credits", 100
        );
        
        return ResponseEntity.ok(credits);
    }
    
    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseCredits(@RequestBody Map<String, Object> purchaseRequest) {
        // Mock implementation to purchase credits
        String userId = (String) purchaseRequest.get("userId");
        Integer packageId = (Integer) purchaseRequest.get("packageId");
        
        Map<String, Object> response = new HashMap<>();
        response.put("userId", userId);
        response.put("packageId", packageId);
        response.put("creditsAdded", 20);
        response.put("totalCredits", 120);
        response.put("transactionId", "txn_123456");
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/packages")
    public ResponseEntity<?> getCreditPackages() {
        // Mock implementation to return credit packages
        List<Map<String, Object>> packages = Arrays.asList(
            Map.of(
                "id", 1,
                "name", "Basic Package",
                "credits", 10,
                "price", 49.99,
                "description", "Perfect for beginners",
                "isActive", true
            ),
            Map.of(
                "id", 2,
                "name", "Standard Package",
                "credits", 20,
                "price", 89.99,
                "description", "Most popular choice",
                "isActive", true
            ),
            Map.of(
                "id", 3,
                "name", "Premium Package",
                "credits", 50,
                "price", 199.99,
                "description", "Best value for serious learners",
                "isActive", true
            )
        );
        
        return ResponseEntity.ok(packages);
    }
    
    @PostMapping("/packages")
    public ResponseEntity<?> createCreditPackage(@RequestBody Map<String, Object> packageRequest) {
        // Mock implementation to create a credit package
        Map<String, Object> newPackage = new HashMap<>(packageRequest);
        newPackage.put("id", 4);
        newPackage.put("isActive", true);
        
        return ResponseEntity.ok(newPackage);
    }
    
    @GetMapping("/transactions/{userId}")
    public ResponseEntity<?> getUserTransactions(@PathVariable String userId) {
        // Mock implementation to return user credit transactions
        List<Map<String, Object>> transactions = Arrays.asList(
            Map.of(
                "id", "txn_123456",
                "userId", userId,
                "amount", 20,
                "type", "PURCHASE",
                "description", "Purchase of Standard Package",
                "referenceId", "pkg_2",
                "createdAt", "2025-04-20T10:30:00Z"
            ),
            Map.of(
                "id", "txn_123457",
                "userId", userId,
                "amount", -1,
                "type", "USE",
                "description", "Booking for lesson on 2025-05-01",
                "referenceId", "booking_1",
                "createdAt", "2025-04-21T14:45:00Z"
            )
        );
        
        return ResponseEntity.ok(transactions);
    }
}