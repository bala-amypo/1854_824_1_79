package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    // ✅ Manually create UserServiceImpl
    public AuthController(UserRepository userRepository) {
        this.userService = new UserServiceImpl(userRepository);
        this.jwtUtil = new JwtUtil(
                "testsecretkeytestsecretkeytestsecretkey",
                3600000
        );
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {

        User saved = userService.register(user);

        String token = jwtUtil.generateToken(
                saved.getId(),
                saved.getEmail(),
                saved.getRole()
        );

        return ResponseEntity.ok(token);
    }
}
