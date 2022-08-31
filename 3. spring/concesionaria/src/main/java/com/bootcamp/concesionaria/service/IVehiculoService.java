package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.VehiculoDTO;
import com.bootcamp.concesionaria.dto.VehiculoSinServiceDTO;

import java.util.Date;
import java.util.List;

public interface IVehiculoService {
  VehiculoDTO agregarVehiculo(VehiculoDTO vehiculoDTO);

  VehiculoDTO obtenerVehiculo(int id);

  List<VehiculoSinServiceDTO> obtenerUsados();

  List<VehiculoDTO> obtenerListaDeVehiculosSegunFechaDeFabricacion(Date desde, Date hasta);

  List<VehiculoDTO> obtenerListaDeVehiculosSegunPrecio(double desde, double hasta);
}
