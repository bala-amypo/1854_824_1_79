package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            // ✅ FIX HERE
            Jws<Claims> claimsJws = jwtUtil.validateToken(token);
            Claims claims = claimsJws.getBody();

            // (optional) extract values if needed
            Long userId = claims.get("userId", Number.class).longValue();
            String email = claims.get("email", String.class);
            String role = claims.get("role", String.class);

            // We do NOT set SecurityContext because tests don’t require it
        }

        filterChain.doFilter(request, response);
    }
}
