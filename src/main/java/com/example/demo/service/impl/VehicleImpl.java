package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

@Service
public class VehicleImpl implements VehicleService {

    private final VehicleRepository vechicleRepository;
    private final UserRepository userRepository;

    public VehicleImpl(VehicleRepository repository, UserRepository userRepository) {
        this.vechiRepository = vechicleRepository;
        this.userRepository=userRepository
    }

    @Override
    public Vehicle saveVechicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }
}