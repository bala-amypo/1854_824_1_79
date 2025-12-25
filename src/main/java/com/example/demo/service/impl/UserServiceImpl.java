package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // 🔥 REQUIRED BY TESTS
    public UserServiceImpl(UserRepository userRepository) {
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
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    // 🔥 REQUIRED BY TESTS
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
