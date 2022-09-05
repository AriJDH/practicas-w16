package com.bootcamp.seguro.service;

import com.bootcamp.seguro.dto.PatenteDto;
import com.bootcamp.seguro.dto.VehiculoDto;

import java.util.List;

public interface IVehiculoService {
    VehiculoDto findById(Long id);

    List<PatenteDto> findAllBySiniestrosWherePerdidaEconomicaGreaterThan10000();

    List<VehiculoDto> findAllWhereCantidadRuedasGreaterThan4AndIsCurrentAnioFabricacion();

    List<VehiculoDto> findAll(VehiculoDto filter);

    VehiculoDto save(VehiculoDto modelDto);

    VehiculoDto update(Long id, VehiculoDto modelDto);

    void delete(Long id);
}
