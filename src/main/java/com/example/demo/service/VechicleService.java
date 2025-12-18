package com.example.demo.service;

import com.example.demo.entity.Vechicle;



public interface VechicleService{
    Vechicle saveVechicle(Vechicle vechicle);
    List<Vechicle> getVechicleByUserId(Long userId);
}