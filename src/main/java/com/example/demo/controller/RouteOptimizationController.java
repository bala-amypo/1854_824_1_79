package com.example.demo.controller;

import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteOptimizationController {

    private final RouteOptimizationService routeOptimizationService;

    public RouteOptimizationController(
            RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    @PostMapping("/route/optimize/{shipmentId}")
    public ResponseEntity<String> optimizeRoute(
            @PathVariable Long shipmentId) {

        routeOptimizationService.optimizeRoute(shipmentId);
        return ResponseEntity.ok("Route optimized successfully");
    }
}
