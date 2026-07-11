package com.example.token.controller;

import com.example.token.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

@RestController
public class AuthenticationController {

    private final JwtUtil jwtUtil = new JwtUtil(); // In real apps, inject this as a @Component

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestHeader("Authorization") String authHeader) {
        
        // 1. Decode the credentials
        String[] credentials = decodeBasicAuthHeader(authHeader);
        String username = credentials[0];
        String password = credentials[1];

        // 2. (Optional validation) verify if username/pwd matches your database/in-memory users
        
        // 3. Generate Token
        String token = jwtUtil.generateToken(username);

        // 4. Return as JSON response object
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        
        return ResponseEntity.ok(response);
    }

    private String[] decodeBasicAuthHeader(String authHeader) {
        String base64Credentials = authHeader.substring(6);
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        return new String(decodedBytes).split(":", 2);
    }
}