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

    public RouteOptimizationResult() {}

    /* ===== BUILDER ===== */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final RouteOptimizationResult r = new RouteOptimizationResult();

        public Builder id(Long id) { r.id = id; return this; }
        public Builder shipment(Shipment s) { r.shipment = s; return this; }
        public Builder optimizedDistanceKm(Double d) { r.optimizedDistanceKm = d; return this; }
        public Builder estimatedFuelUsageL(Double f) { r.estimatedFuelUsageL = f; return this; }
        public Builder generatedAt(LocalDateTime t) { r.generatedAt = t; return this; }

        public RouteOptimizationResult build() { return r; }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
