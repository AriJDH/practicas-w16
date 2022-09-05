package com.meli.seguroshql.service;

import com.meli.seguroshql.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {

    List<VehicleDto> getVehicles();
    VehicleDto findVehicle(Long id);
    VehicleDto saveVehicle(VehicleDto vehicle);
    void deleteVehicle(Long id);

}
