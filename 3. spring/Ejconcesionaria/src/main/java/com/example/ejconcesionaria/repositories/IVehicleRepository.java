package com.example.ejconcesionaria.repositories;

import com.example.ejconcesionaria.dtos.VehicleDto;
import com.example.ejconcesionaria.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    VehicleDto addVehicle(Vehicle vehicle);
    Vehicle getVehicle(int id);
    List<VehicleDto> getAllVehicles();

}
