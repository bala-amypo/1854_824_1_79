package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
    List<User>findByEmail(String email);
}