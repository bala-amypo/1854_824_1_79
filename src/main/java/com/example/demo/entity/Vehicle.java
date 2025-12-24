package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(unique = true)
    private String vehicleNumber;

    private Double capacityKg;
    private Double fuelEfficiency;

    public Vehicle() {
    }

    public Vehicle(Long id, User user, String vehicleNumber,
                   Double capacityKg, Double fuelEfficiency) {
        this.id = id;
        this.user = user;
        this.vehicleNumber = vehicleNumber;
        this.capacityKg = capacityKg;
        this.fuelEfficiency = fuelEfficiency;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private User user;
        private String vehicleNumber;
        private Double capacityKg;
        private Double fuelEfficiency;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder vehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
            return this;
        }

        public Builder capacityKg(Double capacityKg) {
            this.capacityKg = capacityKg;
            return this;
        }

        public Builder fuelEfficiency(Double fuelEfficiency) {
            this.fuelEfficiency = fuelEfficiency;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(id, user, vehicleNumber, capacityKg, fuelEfficiency);
        }
    }

    public Double getCapacityKg() {
        return capacityKg;
    }

    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
