package com.spring.concesionaria.repository;

import com.spring.concesionaria.DTO.VehicleDTO;
import com.spring.concesionaria.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleDAO {
    boolean add(VehicleDTO v);
    List<VehicleDTO> findAll();
    VehicleDTO findById(String model);
    List<VehicleDTO> findByDate(LocalDate since, LocalDate to);
    List<VehicleDTO> finByPrice(Double since, Double to);
}
