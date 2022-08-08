package com.example.ejconcesionaria.services;

import com.example.ejconcesionaria.dtos.VehicleDto;
import com.example.ejconcesionaria.model.Vehicle;

import java.util.Date;
import java.util.List;

public interface IVehicleServices {
    VehicleDto addVehicle(Vehicle vehicle);
    Vehicle getVehicle(int id);
    List<VehicleDto> getAllVehicles();
    List<VehicleDto> getAllVehiclesByPrice(double since, double to);
    List<VehicleDto> getAllVehiclesByDates(Date since, Date to);
}
