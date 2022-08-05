package com.concesionaria.concensionaria.repository;

import java.sql.Date;
import java.util.List;

import com.concesionaria.concensionaria.entity.VehicleEntity;

public interface IRepository {
    public boolean addVehicle(VehicleEntity vehicle);
    public List<VehicleEntity> getAllVehicles();
    public List<VehicleEntity> getVehiclesByDate(Date since, Date to);
    public List<VehicleEntity> getVehiclesByPrice(Double since, Double to);
    public VehicleEntity getVehicleById(String id);
}
