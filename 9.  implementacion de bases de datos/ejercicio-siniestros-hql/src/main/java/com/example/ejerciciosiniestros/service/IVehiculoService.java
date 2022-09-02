package com.example.ejerciciosiniestros.service;

import com.example.ejerciciosiniestros.dto.VehiculoPatenteDTO;
import com.example.ejerciciosiniestros.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    Vehiculo findVehiculoById(long id);

    Vehiculo saveVehiculo(Vehiculo vehiculo);

    void deleteVehiculo(long id);

    Vehiculo updateVehiculo(Vehiculo vehiculo);

    List<Vehiculo> findAllVehiculos();

    List<VehiculoPatenteDTO> getVehiculoPatentes();
}
