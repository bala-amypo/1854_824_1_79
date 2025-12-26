package com.example.demo.controller;

import com.example.demo.entity.Shipment;
import com.example.demo.service.ShipmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService service;

    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    @PostMapping("/{vehicleId}")
    public Shipment createShipment(@PathVariable Long vehicleId,
                                   @RequestBody Shipment shipment) {
        return service.createShipment(vehicleId, shipment);
    }

    @GetMapping("/{shipmentId}")
    public Shipment getShipment(@PathVariable Long shipmentId) {
        return service.getShipment(shipmentId);
    }
}