package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RouteOptimizationResult;

public interface RouteOptimizationResultRepository
        extends JpaRepository<RouteOptimizationResult, Long> {
}