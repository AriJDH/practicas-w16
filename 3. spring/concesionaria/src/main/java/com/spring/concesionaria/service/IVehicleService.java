package com.spring.concesionaria.service;

import com.spring.concesionaria.DTO.VehicleDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    boolean add(VehicleDTO v);
    List<VehicleDTO> findAll();
    VehicleDTO findById(String model);
    List<VehicleDTO> findByDate(LocalDate since, LocalDate to);
    List<VehicleDTO> findByPrice(Double since, Double to);
}
