package com.example.demo.service;

import com.example.demo.entity.Vehicle;
import java.util.List;

public interface VehicleService {

    Vehicle addVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();
}
