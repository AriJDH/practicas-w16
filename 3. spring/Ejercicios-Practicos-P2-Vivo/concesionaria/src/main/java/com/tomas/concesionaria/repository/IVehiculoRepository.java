package com.tomas.concesionaria.repository;

import com.tomas.concesionaria.entity.Vehiculo;

import java.util.List;

public interface IVehiculoRepository {

    void registrarVehiculo(Vehiculo vehiculo);
    List<Vehiculo> obtenerVehiculo();
    Vehiculo obtenerVehiculoEspecifico(Long id);
    Long consultarIdServicio(Long id);

}
