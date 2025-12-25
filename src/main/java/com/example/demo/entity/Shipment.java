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

    public Shipment() {}

    /* ===== BUILDER ===== */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Shipment s = new Shipment();

        public Builder id(Long id) { s.id = id; return this; }
        public Builder vehicle(Vehicle vehicle) { s.vehicle = vehicle; return this; }
        public Builder pickupLocation(Location l) { s.pickupLocation = l; return this; }
        public Builder dropLocation(Location l) { s.dropLocation = l; return this; }
        public Builder weightKg(Double w) { s.weightKg = w; return this; }
        public Builder scheduledDate(LocalDate d) { s.scheduledDate = d; return this; }

        public Shipment build() { return s; }
    }

    /* ===== GETTERS / SETTERS ===== */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public Location getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(Location l) { this.pickupLocation = l; }

    public Location getDropLocation() { return dropLocation; }
    public void setDropLocation(Location l) { this.dropLocation = l; }

    public Double getWeightKg() { return weightKg; }
    public LocalDate getScheduledDate() { return scheduledDate; }
}
