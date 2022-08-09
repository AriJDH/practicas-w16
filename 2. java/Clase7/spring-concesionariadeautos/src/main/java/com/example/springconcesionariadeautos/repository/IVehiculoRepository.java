package com.example.springconcesionariadeautos.repository;

import com.example.springconcesionariadeautos.entity.Vehiculo;

import java.util.List;

public interface IVehiculoRepository {
    Vehiculo agregarVehiculo(Vehiculo vehiculo);
    List<Vehiculo> obtenerVehiculos();
    Vehiculo obtenerVehiculo(int id);
}
