package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;

import java.time.LocalDate;

@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vechicle_id", nullable = false)
    private Vechicle vechicle;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id", nullable = false)
    private Location pickupLocation;

    @ManyToOne
    @JoinColumn(name = "drop_location_id", nullable = false)
    private Location dropLocation;

    @Column(nullable = false)
    private Double weightKg;

    @Column(nullable = false)
    private LocalDate scheduledDate;

    public Shipment() {}

    public Shipment(Vechicle vehicle, Location pickupLocation, Location dropLocation,
                    Double weightKg, LocalDate scheduledDate) {
        this.vechicle = vechicle;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        setWeightKg(weightKg);
        setScheduledDate(scheduledDate);
    }

    
    public Long getId() {
        return id;
    }

    public Vechicle getVechicle() {
        return vechicle;
    }

    public void setVehicle(Vechicle vechicle) {
        this.vechicle = vechicle;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        if (vechicle != null && weightKg > vechicle.getCapacityKg()) {
            throw new IllegalArgumentException("Weight exceeds vehicle capacity");
        }
        this.weightKg = weightKg;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        if (scheduledDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Scheduled date is in the past");
        }
        this.scheduledDate = scheduledDate;
    }
}