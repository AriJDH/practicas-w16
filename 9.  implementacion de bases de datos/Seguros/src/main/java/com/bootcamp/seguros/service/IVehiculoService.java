package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.MarcaYPatenteVehiculoDto;
import com.bootcamp.seguros.dto.PatenteDto;
import com.bootcamp.seguros.dto.VehiculoDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IVehiculoService {

    List<VehiculoDtoResponse> getAllVehiculos();

    List<MarcaYPatenteVehiculoDto> getAllPatentesYMarcasVehiculos();

    List<PatenteDto> getAllPatentesVehiculosFabricadosAnioCorrienteYMasDeCuatroRuedas(Integer anioFabricacion);
}
