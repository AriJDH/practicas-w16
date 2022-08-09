package com.example.springconcesionariadeautos.service;

import com.example.springconcesionariadeautos.dto.VehiculoDTO;
import com.example.springconcesionariadeautos.dto.VehiculoSinServiceDTO;

import java.util.Date;
import java.util.List;

public interface IVehiculoService {
    VehiculoDTO agregarVehiculo(VehiculoDTO vehiculoDTO);
    VehiculoDTO obtenerVehiculo(int id);
    List<VehiculoSinServiceDTO> obtenerVehiculosUsados();
    List<VehiculoDTO> obtenerListaDeVehiculosSegunFechaDeFabricacion(Date desde, Date hasta);
    List<VehiculoDTO> obtenerListaDeVehiculosSegunPrecio(double desde, double hasta);
}
