package com.bootcamp.concesionaria.repository;

import com.bootcamp.concesionaria.entity.Vehiculo;

import java.util.List;

public interface IVehiculoRepository {
  Vehiculo agregarVehiculo(Vehiculo vehiculo);

  List<Vehiculo> obtenerVehiculos();

  Vehiculo obtenerVehiculo(int id);
}
