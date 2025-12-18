package com.example.demo.service.impl;
import com.example.demo.repository.LocationRepository;
public class Locationimpl implements LocationServices{
    @Autowired
    LocationRepository lrp;
    public Location  createLocation (Location location){
        return lrp.save(user);
    }
    public <
}