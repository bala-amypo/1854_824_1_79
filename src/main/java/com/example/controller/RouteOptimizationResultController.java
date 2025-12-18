package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationResultService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/route-results")
public class RouteOptimizationResultController {

    private final RouteOptimizationResultService service;

    public RouteOptimizationResultController(RouteOptimizationResultService service) {
        this.service = service;
    }

    @PostMapping
    public RouteOptimizationResult saveResult(
            @RequestBody RouteOptimizationResult result) {
        return service.saveResult(result);
    }
}