package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

@Service
public class VehicleImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}