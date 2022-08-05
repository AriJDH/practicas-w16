package com.spring.concesionaria.repository;

import com.spring.concesionaria.DTO.VehicleDTO;
import com.spring.concesionaria.entity.Service;
import com.spring.concesionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VehicleDAOImpl implements IVehicleDAO{

    private List<VehicleDTO> database;

    public VehicleDAOImpl(){

        Service ser1 = new Service(LocalDate.of(2003, 5, 20), 60000, "Change air filters");
        VehicleDTO v1 = new VehicleDTO("Chevrolet", "Corsa", LocalDate.of(2000, 11, 20), 115000, 5, 90000.0, "AR", ser1, 2);
        VehicleDTO v2 = new VehicleDTO("Toyota", "Etios", LocalDate.of(2014, 3, 11), 70000, 5, 130000.0, "AR", ser1, 3);

        database = new ArrayList<>();
        database.add(v1);
        database.add(v2);
    }

    @Override
    public boolean add(VehicleDTO v) {
        try{
            database.add(v);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<VehicleDTO> findAll() {
        return database;
    }

    @Override
    public VehicleDTO findById(String model) {
        return database.stream().filter(v -> v.getModel().equals(model)).findFirst().get();
    }

    @Override
    public List<VehicleDTO> findByDate(LocalDate since, LocalDate to) {
        return database.stream().filter(v -> v.getManufacturingDate().isBefore(to) && v.getManufacturingDate().isAfter(since)).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> finByPrice(Double since, Double to) {
        return database.stream().filter(v -> v.getPrice() >= since && v.getPrice() <= to).collect(Collectors.toList());
    }


}
