package com.example.demo.security;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    public String generateToken(Long userId, String email, String role) {
        String data = userId + ":" + email + ":" + role;
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public String validateToken(String token) {
        return new String(Base64.getDecoder().decode(token));
    }
}
