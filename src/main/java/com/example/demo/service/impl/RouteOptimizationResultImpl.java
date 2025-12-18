package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationResultService;

@Service
public class RouteOptimizationResultImpl implements RouteOptimizationResultService {

    @Override
    public RouteOptimizationResult saveresult(RouteOptimizationResult result) {
        return result;
    }
}