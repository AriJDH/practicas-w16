package com.vehiculo.api.service;

import com.vehiculo.api.dto.BrandPatenteDto;
import com.vehiculo.api.dto.PatenteDto;
import com.vehiculo.api.dto.PatenteMarcaModeloDto;

import java.util.List;

public interface IVehiculoService {

    List<PatenteDto> findAllPatentes();

    List<BrandPatenteDto> findPatentesAndBrandOrderByYear();

    List<PatenteDto> findPatenteWithMoreThan4WheelsAndIsOfThisYear();

    List<PatenteMarcaModeloDto> getVehiculoWithBigSiniestro();
}
