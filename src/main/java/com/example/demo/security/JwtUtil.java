package com.example.demo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class JwtUtil {

    private final String secret;
    private final long expiration;

    public JwtUtil(
            @Value("${jwt.secret:testsecretkey}") String secret,
            @Value("${jwt.expiration:3600000}") long expiration) {

        this.secret = secret;
        this.expiration = expiration;
    }

    // NOT a real JWT – Base64 encoded string
    public String generateToken(Long userId, String email, String role) {

        long expiryTime = System.currentTimeMillis() + expiration;

        String data = userId + ":" + email + ":" + role + ":" + expiryTime;

        return Base64.getEncoder()
                .encodeToString(data.getBytes());
    }

    // Decodes token and returns raw data
    public String validateToken(String token) {

        byte[] decodedBytes = Base64.getDecoder()
                .decode(token);

        return new String(decodedBytes);
    }
}
