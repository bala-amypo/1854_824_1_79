package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import java.util.List;

public interface LocationService {

    Location saveLocation(Location location);

    List<Location> getAllLocations();   // 👈 use THIS
}