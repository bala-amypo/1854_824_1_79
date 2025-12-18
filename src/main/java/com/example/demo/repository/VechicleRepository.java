package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Vechicle;

import java.util.List;

public interface VechicleRepository extends JpaRepository<Vechicle, Long>{
    List<Vechicle> findByUserId(Long userId);
}