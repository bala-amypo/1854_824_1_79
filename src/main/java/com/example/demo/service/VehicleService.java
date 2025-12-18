package com.example.demo.service;

import com.example.demo.entity.Vehicle;

import java.util.List;

public interface VehicleService{
    Vehicle saveVechicle(Vehicle vehicle);
    List<Vehicle> getVehiclesByUserId(Long userId);
}