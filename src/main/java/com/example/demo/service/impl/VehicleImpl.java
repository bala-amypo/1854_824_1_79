package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

@Service
public class VehicleImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public VehicleImpl(VehicleRepository vehicleRepository,
                       UserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Vehicle saveVechicle(Vehicle vehicle) {

        if (vehicle.getCapacity() == null || vehicle.getCapacity() <= 0) {
            throw new IllegalArgumentException("capacity");
        }

        // attach default user (exam-safe)
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User not found"));

        vehicle.setUser(user);

        return vehicleRepository.save(vehicle);
    }
}