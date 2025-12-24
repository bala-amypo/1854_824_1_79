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

    /* ===== GETTERS / SETTERS (TEST REQUIRED) ===== */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // REQUIRED BY TESTS
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) { // REQUIRED
        this.vehicleNumber = vehicleNumber;
    }

    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
