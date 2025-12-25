package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // REQUIRED BY APP
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 🔥 REQUIRED BY TEST CASES
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public User registerUser(User user) {
        user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> u = userRepository.findByEmail(email);
        return u.orElse(null);
    }

    // 🔥 REQUIRED BY TESTS
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
