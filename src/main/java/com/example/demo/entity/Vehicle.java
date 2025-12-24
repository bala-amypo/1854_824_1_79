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

    /* ===== GETTERS ===== */

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Double getCapacityKg() {
        return capacityKg;
    }

    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }

    /* ===== SETTERS (REQUIRED) ===== */

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {   // 🔥 FIX FOR ERROR
        this.user = user;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setCapacityKg(Double capacityKg) {
        this.capacityKg = capacityKg;
    }

    public void setFuelEfficiency(Double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }
}
