package com.meli.seguroshql.service;

import com.meli.seguroshql.dto.VehicleDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class VehicleService implements IVehicleService {

    @Override
    @Transactional(readOnly = true)
    public List<VehicleDto> getVehicles() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public VehicleDto findVehicle(Long id) {
        return null;
    }

    @Override
    @Transactional
    public VehicleDto saveVehicle(VehicleDto vehicle) {
        return null;
    }

    @Override
    @Transactional
    public void deleteVehicle(Long id) {

    }
}
