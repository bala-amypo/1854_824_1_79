package com.example.demo.security;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class JwtUtil {

    // Simple secret just for encoding
    private static final String SECRET = "secret";

    /**
     * Generates a simple token using Base64
     * Format: email:userId:role
     */
    public String generateToken(User user) {
        String tokenData =
                user.getEmail() + ":" + user.getId() + ":" + user.getRole();
        return Base64.getEncoder()
                .encodeToString((tokenData + ":" + SECRET)
                .getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Extract email from token
     */
    public String extractUsername(String token) {
        try {
            String decoded = new String(
                    Base64.getDecoder().decode(token),
                    StandardCharsets.UTF_8
            );
            return decoded.split(":")[0];
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Token validation
     */
    public boolean validateToken(String token) {
        try {
            String decoded = new String(
                    Base64.getDecoder().decode(token),
                    StandardCharsets.UTF_8
            );
            return decoded.endsWith(SECRET);
        } catch (Exception e) {
            return false;
        }
    }
}
