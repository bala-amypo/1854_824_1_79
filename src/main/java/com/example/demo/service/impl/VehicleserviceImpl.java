package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {

        // Vehicle number uniqueness
        if (vehicleRepository.existsByVehicleNumber(vehicle.getVehicleNumber())) {
            throw new IllegalArgumentException("Vehicle number already exists");
        }

        // Capacity validation
        if (vehicle.getCapacityKg() == null || vehicle.getCapacityKg() <= 0) {
            throw new IllegalArgumentException("Invalid capacity");
        }

        return vehicleRepository.save(vehicle);
    }
}