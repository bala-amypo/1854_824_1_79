package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;

    public Location() {}

    /* ===== BUILDER ===== */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Location l = new Location();

        public Builder id(Long id) {
            l.id = id;
            return this;
        }

        public Builder name(String name) {
            l.name = name;
            return this;
        }

        public Builder latitude(Double latitude) {
            l.latitude = latitude;
            return this;
        }

        public Builder longitude(Double longitude) {
            l.longitude = longitude;
            return this;
        }

        public Location build() {
            return l;
        }
    }

    /* ===== GETTERS / SETTERS ===== */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
}
