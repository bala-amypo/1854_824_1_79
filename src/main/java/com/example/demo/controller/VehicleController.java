package com.example.demo.controller;

import com.example.demo.entity.Vehicle;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import com.example.demo.service.impl.VehicleServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    // ✅ Manually create service using repositories
    public VehicleController(
            VehicleRepository vehicleRepository,
            UserRepository userRepository) {

        this.vehicleService =
                new VehicleServiceImpl(vehicleRepository, userRepository);
    }

    @PostMapping("/{userId}")
    public Vehicle addVehicle(
            @PathVariable Long userId,
            @RequestBody Vehicle vehicle) {

        return vehicleService.addVehicle(userId, vehicle);
    }

    @GetMapping("/user/{userId}")
    public List<Vehicle> getVehiclesByUser(
            @PathVariable Long userId) {

        return vehicleService.getVehiclesByUser(userId);
    }
}
