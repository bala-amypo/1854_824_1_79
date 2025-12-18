package com.example.demo.service.impl;

import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        if (vehicle.getCapacityKg() <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getVehiclesByUserId(Long userId) {
        return vehicleRepository.findByUserId(userId);
    }
}