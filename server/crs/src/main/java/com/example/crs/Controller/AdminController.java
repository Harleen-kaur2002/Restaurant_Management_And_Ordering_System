package com.example.crs.Controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")  
@RestController
@RequestMapping("/")
public class AdminController {
    private final String HARDCODED_USERNAME = "admin";
    private final String HARDCODED_PASSWORD = "admin123";

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

      
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        if (HARDCODED_USERNAME.equals(username) && HARDCODED_PASSWORD.equals(password)) {
            return ResponseEntity.ok(Map.of("message", "Login successful"));
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
        }
    }
}
