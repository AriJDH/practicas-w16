package com.example.ejconcesionaria.services;

import com.example.ejconcesionaria.dtos.VehicleDto;
import com.example.ejconcesionaria.model.Vehicle;
import com.example.ejconcesionaria.repositories.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VehicleServices implements IVehicleServices {
    @Autowired
    IVehicleRepository vehicleRepository;

    @Override
    public VehicleDto addVehicle(Vehicle vehicle) {
        return vehicleRepository.addVehicle(vehicle);
    }

    @Override
    public Vehicle getVehicle(int id) {
        return vehicleRepository.getVehicle(id);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.getAllVehicles();
    }

    @Override
    public List<VehicleDto> getAllVehiclesByPrice(double since, double to) {
        return vehicleRepository.getAllVehicles().stream().filter(v -> v.getPrice() >= since && v.getPrice() <= to).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<VehicleDto> getAllVehiclesByDates(Date since, Date to) {

        var res = vehicleRepository.getAllVehicles().stream().filter(v -> v.getManuFacturingDate().after((Date) since) && v.getManuFacturingDate().before((Date)to)).collect(java.util.stream.Collectors.toList());
        return res;
    }
}
