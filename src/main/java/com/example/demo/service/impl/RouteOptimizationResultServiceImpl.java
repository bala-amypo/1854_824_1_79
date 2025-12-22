package com.example.demo.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.entiry.RouteOptimizationResult;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.service.RouteOptimizationResultService;

@Service
public class RouteOptimizationResultServiceImpl
        implements RouteOptimizationResultService {

    private final RouteOptimizationResultRepository repository;

    public RouteOptimizationResultServiceImpl(
            RouteOptimizationResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public RouteOptimizationResult saveResult(
            RouteOptimizationResult result) {

        result.setGeneratedAt(LocalDateTime.now());

        return repository.save(result);
    }
}