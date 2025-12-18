package com.example.demo.service;

import com.example.demo.entity.Shipment;

import java.util.List;

public interface ShipmentService{
    Shipment createShipment(Shipment shipment);
    List<Shipment> getShipmentsbyVechicleId(Long vechicleId);
}