package com.example.siniestros.service;


import com.example.siniestros.controller.SiniestroDto;
import com.example.siniestros.dto.PatenteDto;
import com.example.siniestros.dto.PatenteMarcaDto;
import com.example.siniestros.dto.VehiculoDto;

import java.util.List;

public interface IVehiculoService {

    List<PatenteDto> findAllPantentes();

    List<PatenteMarcaDto> findAllPatentesAndMarcas();

    Object createVehiculo(VehiculoDto vehiculoDto);

    Object createSiniestro(SiniestroDto siniestroDto);

    List<PatenteDto> findAllPatentesWithMoreThan4Ruedas();
}
