package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

@Service
public class VehicleImpl implements VehicleService {

    private final VehicleRepository repository;
    private final 

    public VehicleImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vehicle saveVechicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }
}