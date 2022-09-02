package com.vehiculo.api.service;

import com.vehiculo.api.dto.BrandPatenteDto;
import com.vehiculo.api.dto.PatenteDto;
import com.vehiculo.api.dto.PatenteMarcaModeloDto;
import com.vehiculo.api.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    @Override
    public List<PatenteDto> findAllPatentes() {
        return vehiculoRepository.getAllVehiculos().stream()
                .map(v-> new PatenteDto(v.getPatente()))
                .collect(Collectors.toList());
    }

    @Override
    public List<BrandPatenteDto> findPatentesAndBrandOrderByYear() {
        return vehiculoRepository.getAllVehiculosOrderByAnio().stream()
                .map(v-> new BrandPatenteDto(v.getMarca(),v.getPatente()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatenteDto> findPatenteWithMoreThan4WheelsAndIsOfThisYear() {
        return vehiculoRepository.getVehiculoByCantidadRuedasEqualsAndAnioFabricacion().stream()
                .map(v-> new PatenteDto(v.getPatente()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatenteMarcaModeloDto> getVehiculoWithBigSiniestro() {
        return vehiculoRepository.getVehiculoWithBigSiniestro()
                .stream()
                .map(vehiculo -> new PatenteMarcaModeloDto(vehiculo.getMarca(),vehiculo.getPatente(),vehiculo.getModelo()))
                .collect(Collectors.toList());
    }
}
