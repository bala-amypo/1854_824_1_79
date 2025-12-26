package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User registerUser(User user);   // ✅ this is the expected one

    User findByEmail(String email);
}
