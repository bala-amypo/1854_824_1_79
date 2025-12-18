package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShipmentImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment createShipment(Shipment shipment) {

        Vehicle vehicle = shipment.getVehicle();

        if (shipment.getWeightKg() > vehicle.getCapacityKg()) {
            throw new IllegalArgumentException("Weight exceeds vehicle capacity");
        }

        if (shipment.getScheduledDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Scheduled date is in the past");
        }

        return shipmentRepository.save(shipment);
    }

    @Override
    public List<Shipment> getShipmentsByVehicleId(Long vehicleId) {
        return shipmentRepository.findByVehicleId(vehicleId);
    }
}