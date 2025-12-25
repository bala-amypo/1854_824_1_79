package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/route/optimize")
    public ResponseEntity<String> optimizeRoute() {
        routeOptimizationService.optimizeRoute();
        return ResponseEntity.ok("Route optimized successfully");
    }

    @GetMapping("/route/result/{id}")
    public ResponseEntity<RouteOptimizationResult> getResultById(
            @PathVariable Long id) {

        RouteOptimizationResult result =
                routeOptimizationService.getResultById(id);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/route/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Optimization completed");
    }

    @GetMapping("/route/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("SUCCESS");
    }
}
