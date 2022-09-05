package com.bootcamp.seguro.service;

import com.bootcamp.seguro.dto.PatenteDto;
import com.bootcamp.seguro.dto.SiniestroDto;
import com.bootcamp.seguro.dto.VehiculoDto;
import com.bootcamp.seguro.entity.Siniestro;
import com.bootcamp.seguro.entity.Vehiculo;
import com.bootcamp.seguro.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class VehiculoService implements IVehiculoService {
    private final VehiculoRepository vehiculoRepository;

    private final ModelMapper modelMapper;

    public VehiculoService(VehiculoRepository vehiculoRepository, ModelMapper modelMapper) {
        this.vehiculoRepository = vehiculoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VehiculoDto findById(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe nada con ese id. uwu"));
        return mapToVehiculoDto(vehiculo);
    }

    @Override
    public List<PatenteDto> findAllBySiniestrosWherePerdidaEconomicaGreaterThan10000() {
        return vehiculoRepository.findAllBySiniestrosWherePerdidaEconomicaGreaterThan10000().stream()
                .map(v -> new PatenteDto(v.getPatente()))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoDto> findAllWhereCantidadRuedasGreaterThan4AndIsCurrentAnioFabricacion() {
        return vehiculoRepository.findAllWhereCantidadRuedasGreaterThan4AndIsCurrentAnioFabricacion()
                .stream()
                .map(this::mapToVehiculoDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoDto> findAll(VehiculoDto filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withMatcher("marca", contains().ignoreCase())
                .withMatcher("modelo", contains().ignoreCase())
                .withMatcher("patente", exact().ignoreCase())
                .withIgnoreNullValues()
                .withIgnorePaths("id", "siniestros");

        Vehiculo vehiculo = mapToVehiculo(filter);
        return vehiculoRepository.findAll(
                        Example.of(vehiculo, matcher),
                        Sort.by(Sort.Direction.ASC, "anioFabricacion")
                ).stream()
                .map(this::mapToVehiculoDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehiculoDto save(VehiculoDto modelDto) {
        return mapToVehiculoDto(vehiculoRepository.save(mapToVehiculo(modelDto)));
    }

    @Override
    public VehiculoDto update(Long id, VehiculoDto modelDto) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe nada con ese id. uwu"));
        modelMapper.map(modelDto, vehiculo);
        return mapToVehiculoDto(vehiculoRepository.save(vehiculo));
    }

    @Override
    public void delete(Long id) {
        vehiculoRepository.deleteById(id);
    }

    private VehiculoDto mapToVehiculoDto(Vehiculo vehiculo) {
        VehiculoDto vehiculoDto = modelMapper.map(vehiculo, VehiculoDto.class);
        if (vehiculo.getSiniestros() == null) return vehiculoDto;
        vehiculoDto.setSiniestros(vehiculo.getSiniestros().stream()
                .map(this::mapToSiniestroDto)
                .collect(Collectors.toList()));
        return vehiculoDto;
    }

    private Vehiculo mapToVehiculo(VehiculoDto vehiculoDto) {
        Vehiculo vehiculo = modelMapper.map(vehiculoDto, Vehiculo.class);
        if (vehiculoDto.getSiniestros() == null) return vehiculo;
        vehiculo.setSiniestros(vehiculoDto.getSiniestros().stream()
                .map(this::mapToSiniestro)
                .collect(Collectors.toList()));
        return vehiculo;
    }

    private SiniestroDto mapToSiniestroDto(Siniestro siniestro) {
        return modelMapper.map(siniestro, SiniestroDto.class);
    }

    private Siniestro mapToSiniestro(SiniestroDto siniestroDto) {
        return modelMapper.map(siniestroDto, Siniestro.class);
    }
}
