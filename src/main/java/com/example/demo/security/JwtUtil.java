package com.example.demo.security;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String secret;
    private final long expiration;

    public JwtUtil(@Value("${jwt.secret}") String secret,
                   @Value("${jwt.expiration}") long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    public String generateToken(Long userId, String email, String role) {
        String tokenData = userId + ":" + email + ":" + role;
        return Base64.getEncoder().encodeToString(tokenData.getBytes());
    }

    public String validateToken(String token) {
        byte[] decoded = Base64.getDecoder().decode(token);
        return new String(decoded);
    }
}
