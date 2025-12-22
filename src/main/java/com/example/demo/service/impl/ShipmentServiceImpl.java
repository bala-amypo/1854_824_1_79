package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment createShipment(Shipment shipment) {

        // ✅ Rule 1: Weight validation
        if (shipment.getWeightKg() > shipment.getVehicle().getCapacityKg()) {
            throw new IllegalArgumentException("exceeds vehicle capacity");
        }

        // ✅ Rule 2: Date validation
        if (shipment.getScheduledDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("scheduled date is in the past");
        }

        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found"));
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }
}