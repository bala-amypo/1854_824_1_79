package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {

    private final RouteOptimizationService routeOptimizationService;

    public RouteOptimizationController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    @PostMapping("/{shipmentId}")
    public RouteOptimizationResult optimizeRoute(
            @PathVariable Long shipmentId) {

        return routeOptimizationService.optimizeRoute(shipmentId);
    }

    @GetMapping("/result/{resultId}")
    public RouteOptimizationResult getResult(
            @PathVariable Long resultId) {

        return routeOptimizationService.getResult(resultId);
    }
}
