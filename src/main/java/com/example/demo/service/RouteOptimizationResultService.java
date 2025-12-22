package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResult;
import java.util.List;

public interface RouteOptimizationResultService {

    RouteOptimizationResult saveResult(RouteOptimizationResult result);

    List<RouteOptimizationResult> getAllResults();
}
