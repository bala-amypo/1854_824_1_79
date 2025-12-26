package com.example.demo.controller;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import com.example.demo.service.impl.LocationServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    // ✅ Manually create service (NO Spring bean needed)
    public LocationController(LocationRepository locationRepository) {
        this.locationService = new LocationServiceImpl(locationRepository);
    }

    @PostMapping
    public Location create(@RequestBody Location location) {
        return locationService.createLocation(location);
    }

    @GetMapping
    public List<Location> getAll() {
        return locationService.getAllLocations();
    }
}
