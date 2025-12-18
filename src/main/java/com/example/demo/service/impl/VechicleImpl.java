package com.example.demo.service.impl;

import com.example.demo.entity.Vechicle;
import com.example.demo.repository.VechicleRepository;
import com.example.demo.service.VechicleService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VechicleImpl implements VechicleService {

    private final VechicleRepository vechicleRepository;

    public VechicleImpl(VehicleRepository vechicleRepository) {
        this.vehicleRepository = vechicleRepository;
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