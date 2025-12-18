package com.example.demo.service.impl;

import com.example.demo.entity.user;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BcryptPasswordEncoder;

@Service
public class UserImpl implements UserService{
    private final UserRepository userRepository;
    private final BcryptPasswordEncoder passwordEncoder = new BcryptPasswordEncoder();

    public UserImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User registerUser(User user){
        if (user.getRole() == null){
            user.setrole("USER");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}