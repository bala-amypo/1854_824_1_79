package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/save")
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVechicle(vehicle);
    }
}