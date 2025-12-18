package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;

@Service
public class ShipmentImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public List<Shipment> getShipmentsByVehicleId(Long vehicleId) {
        return shipmentRepository.findByVehicleId(vehicleId);
    }
}