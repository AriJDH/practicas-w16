package com.bootcamp.autos.service;

import com.bootcamp.autos.dto.VehiculoPatentesDto;

import java.util.HashMap;
import java.util.List;

public interface IVehiculoService {

    List<VehiculoPatentesDto> getPatentesVehiculos();

    List<HashMap<String, String>> getPatenteMarcaVehiculos();

    List<VehiculoPatentesDto> getPatentesByFechaByRuedaVehiculos();

    List<HashMap<String, String>> getVehiculosSiniestro();

}
