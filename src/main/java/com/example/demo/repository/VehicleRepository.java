package com.example.demo.repository;

import com.example.demo.entity.Vehicle;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByVehicleNumber(String vehicleNumber);

    List<Vehicle> findByUserId(Long userId);   // REQUIRED
}
