package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationResultService;

import org.springframework.stereotype.Service;

@Service
public class RouteOptimizationResultImpl
        implements RouteOptimizationResultService {

    private final RouteOptimizationResultRepository repository;

    public RouteOptimizationResultImpl(RouteOptimizationResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public RouteOptimizationResult saveResult(RouteOptimizationResult result) {
        return repository.save(result);
    }
}