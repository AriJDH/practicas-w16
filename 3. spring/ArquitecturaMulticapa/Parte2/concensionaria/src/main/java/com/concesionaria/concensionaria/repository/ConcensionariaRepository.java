package com.concesionaria.concensionaria.repository;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.concesionaria.concensionaria.entity.VehicleEntity;

@Repository
public class ConcensionariaRepository implements IRepository {
    
    private HashMap<Integer, VehicleEntity> vehicles;
    private Integer id;

    @PostConstruct
    public void init() {
        vehicles = new HashMap<>();
        id = 0;
    }

    public boolean addVehicle(VehicleEntity vehicle) {
        vehicles.put(id++, vehicle);
        
        return true;
    }

    @Override
    public List<VehicleEntity> getAllVehicles() {
        List<VehicleEntity> vehiclesList = vehicles.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
        return vehiclesList;
    }

    @Override
    public List<VehicleEntity> getVehiclesByDate(Date since, Date to) {
        List<VehicleEntity> vehiclesList = vehicles.
                                                entrySet().
                                                stream().
                                                map(entry -> entry.getValue())
                                                .filter(vehicle -> vehicle.getManufacturingDate().after(since) && vehicle.getManufacturingDate().before(to))
                                                .collect(Collectors.toList());

        return vehiclesList;
    }

    @Override
    public List<VehicleEntity> getVehiclesByPrice(Double since, Double to) {
        List<VehicleEntity> vehiclesList = vehicles.
                                                entrySet().
                                                stream().
                                                map(entry -> entry.getValue())
                                                .filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to)
                                                .collect(Collectors.toList());

        return vehiclesList;
    }
    

    @Override
    public VehicleEntity getVehicleById(String id) {
        return vehicles.get(Integer.parseInt(id));
    }
}
