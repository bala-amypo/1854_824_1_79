package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Location pickupLocation;

    @ManyToOne
    private Location dropLocation;

    private Double weightKg;
    private LocalDate scheduledDate;

    public Shipment() {
    }

    public Long getId() {
        return id;
    }

    public Double getWeightKg() {   // REQUIRED
        return weightKg;
    }

    public LocalDate getScheduledDate() { // REQUIRED
        return scheduledDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setVehicle(Vehicle vehicle) {   // REQUIRED
        this.vehicle = vehicle;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }
}
