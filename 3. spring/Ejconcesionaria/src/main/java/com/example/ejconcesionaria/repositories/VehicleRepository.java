package com.example.ejconcesionaria.repositories;

import com.example.ejconcesionaria.dtos.VehicleDto;
import com.example.ejconcesionaria.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository {
    private HashMap<Integer,Vehicle> vehicles;
    private int id;

    public VehicleRepository() {
        vehicles = new HashMap();
        id = 1;
    }

    @Override
    public VehicleDto addVehicle(Vehicle vehicle) {
        Vehicle vehicleToAdd = new Vehicle(id, vehicle.getBrand(), vehicle.getModel(), vehicle.getManuFacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getCountOfOwners(), vehicle.getServices());
        vehicles.put(id,vehicleToAdd);
        id++;

        return new VehicleDto(vehicle.getBrand(), vehicle.getModel(), vehicle.getManuFacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getCountOfOwners());
    }

    @Override
    public Vehicle getVehicle(int id) {
        return vehicles.get(id);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return vehicles.values().stream().map(vehicle -> new VehicleDto(vehicle.getBrand(), vehicle.getModel(), vehicle.getManuFacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getCountOfOwners())).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }


}
