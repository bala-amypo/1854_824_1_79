package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationResultService;

@RestController
@RequestMapping("/api/route-results")
public class RouteOptimizationResultController {

    private final RouteOptimizationResultService service;

    public RouteOptimizationResultController(
            RouteOptimizationResultService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RouteOptimizationResult> createResult(
            @RequestBody RouteOptimizationResult result) {

        RouteOptimizationResult saved =
                service.saveResult(result);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}