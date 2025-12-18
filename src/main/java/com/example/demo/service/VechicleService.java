package com.example.demo.service;

import com.example.demo.entity.Vechicle;

import java.util.List;

public interface VechicleService{
    Vechicle saveVechicle(Vechicle vechicle);
    List<Vechicle> getVechicleByUserId(Long userId);
}