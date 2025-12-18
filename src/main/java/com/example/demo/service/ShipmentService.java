package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Shipment;

public interface ShipmentService{
    Shipment createShipment(Shipment shipment);
    List<Shipment> getShipmentsbyVechicleId(Long vechicleId);
}