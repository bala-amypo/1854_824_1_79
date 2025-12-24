package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    public RouteOptimizationServiceImpl(
            ShipmentRepository shipmentRepository,
            RouteOptimizationResultRepository resultRepository) {

        this.shipmentRepository = shipmentRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));

        Location pickup = shipment.getPickupLocation();
        Location drop = shipment.getDropLocation();

        // Distance calculation (simple Euclidean distance)
        double distance = Math.hypot(
                pickup.getLatitude().doubleValue()
                        - drop.getLatitude().doubleValue(),
                pickup.getLongitude().doubleValue()
                        - drop.getLongitude().doubleValue()
        );

        Vehicle vehicle = shipment.getVehicle();

        // Fuel usage calculation
        double fuelUsed = distance / vehicle.getFuelEfficiency();

        RouteOptimizationResult result =
                new RouteOptimizationResult(
                        shipment,
                        Double.valueOf(distance),
                        Double.valueOf(fuelUsed),
                        LocalDateTime.now()
                );

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long resultId) {

        return resultRepository.findById(resultId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Result not found"));
    }
}
