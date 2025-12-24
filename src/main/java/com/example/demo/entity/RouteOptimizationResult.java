package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Shipment shipment;

    private Double optimizedDistanceKm;
    private Double estimatedFuelUsageL;
    private LocalDateTime generatedAt;

    public RouteOptimizationResult() {
    }

    public static Builder builder() {   // REQUIRED
        return new Builder();
    }

    public static class Builder {
        private Shipment shipment;
        private Double optimizedDistanceKm;
        private Double estimatedFuelUsageL;
        private LocalDateTime generatedAt;

        public Builder shipment(Shipment shipment) {
            this.shipment = shipment;
            return this;
        }

        public Builder optimizedDistanceKm(Double optimizedDistanceKm) {
            this.optimizedDistanceKm = optimizedDistanceKm;
            return this;
        }

        public Builder estimatedFuelUsageL(Double estimatedFuelUsageL) {
            this.estimatedFuelUsageL = estimatedFuelUsageL;
            return this;
        }

        public Builder generatedAt(LocalDateTime generatedAt) {
            this.generatedAt = generatedAt;
            return this;
        }

        public RouteOptimizationResult build() {
            RouteOptimizationResult r = new RouteOptimizationResult();
            r.shipment = shipment;
            r.optimizedDistanceKm = optimizedDistanceKm;
            r.estimatedFuelUsageL = estimatedFuelUsageL;
            r.generatedAt = generatedAt;
            return r;
        }
    }
}
