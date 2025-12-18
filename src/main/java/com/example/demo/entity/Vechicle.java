package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Vechicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false, unique = true)
    private String vehicleNumber;
    @Column(nullable = false)
    private Double capacityKg;
    @Column(nullable = false)
    private Double fuelEfficiency; // km per liter
    public Vechicle() {

    }
    public Vechicle(User user, String vehicleNumber, Double capacityKg, Double fuelEfficiency) {
        this.user = user;
        this.vehicleNumber = vehicleNumber;
        setCapacityKg(capacityKg); // validation
        this.fuelEfficiency = fuelEfficiency;
    }
    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getVechicleNumber() {
        return vechicleNumber;
    }
    public void setVechicleNumber(String vehicleNumber) {
        this.vechicleNumber = vechicleNumber;
    }
    public Double getCapacityKg() {
        return capacityKg;
    }
    public void setCapacityKg(Double capacityKg) {
        if (capacityKg <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        this.capacityKg = capacityKg;
    }
    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }
    public void setFuelEfficiency(Double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }
}