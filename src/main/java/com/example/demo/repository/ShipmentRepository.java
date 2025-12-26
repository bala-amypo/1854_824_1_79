package com.example.demo.repository;

import com.example.demo.entity.Shipment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    List<Shipment> findByVehicleId(Long vehicleId);
}
