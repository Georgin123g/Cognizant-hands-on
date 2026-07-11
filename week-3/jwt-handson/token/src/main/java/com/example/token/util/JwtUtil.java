package com.example.token.util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.security.Key;

public class JwtUtil {
    private String secret = "your_ultra_secret_key_that_is_long_enough_for_hs256";
    private long expirationMs = 3600000; // 1 hour
    private final Key key = Keys.hmacShaKeyFor(secret.getBytes());
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key,SignatureAlgorithm.HS256)
                .compact();
    }
}