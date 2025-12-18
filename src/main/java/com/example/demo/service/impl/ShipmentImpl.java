package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;

@Service
public class ShipmentImpl implements ShipmentService {

    private final ShipmentRepository repository;

    public ShipmentImpl(ShipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Shipment createShipment(Shipment shipment) {
        return repository.save(shipment);
    }

    @Override
    public List<Shipment> getShipmentsbyVechicleId(Long vehicleId) {
        return repository.findByVehicleId(vehicleId);
    }
}