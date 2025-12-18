package com.example.demo.repository;

import org.springframework.data.jpa.repository.Jparepository;

import com.example.demo.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long>{
    
}