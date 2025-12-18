package com.example.demo.service.impl;
import com.example.demo.repository.LocationRepository;
public class LocationImpl implements LocationServices{
    @Autowired
    LocationRepository lrp;
    public Location  createLocation (Location location){
        if(location.getLatitude()>90){
            throw new IllegalArgumentException("latitude");
        }
        return lrp.save(user);
    }
    public List<Location> getAllLocation(){
        return lrp.findAll();
    }
}