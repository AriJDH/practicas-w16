package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.MarcaYPatenteVehiculoDto;
import com.bootcamp.seguros.dto.PatenteDto;
import com.bootcamp.seguros.dto.VehiculoDtoResponse;
import com.bootcamp.seguros.dto.VehiculoSiniestro;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IVehiculoService {

    List<VehiculoDtoResponse> getAllVehiculos();

    List<MarcaYPatenteVehiculoDto> getAllPatentesYMarcasVehiculos();

    List<PatenteDto> getAllPatentesVehiculosFabricadosAnioCorrienteYMasDeCuatroRuedas(Integer anioFabricacion);

    List<String> vehiculosConperdidaSuperior1000();

    List<VehiculoSiniestro> vehiculosYCostoFinalPerdidaSuperior1000();
}
