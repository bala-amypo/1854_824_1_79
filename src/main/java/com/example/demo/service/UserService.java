package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User register(User user);

    User registerUser(User user);     // REQUIRED BY AuthController

    User findByEmail(String email);   // REQUIRED BY AuthController
}
