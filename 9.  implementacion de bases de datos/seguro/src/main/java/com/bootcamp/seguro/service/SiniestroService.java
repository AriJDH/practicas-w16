package com.bootcamp.seguro.service;

import com.bootcamp.seguro.dto.SiniestroDto;
import com.bootcamp.seguro.dto.VehiculoDto;
import com.bootcamp.seguro.entity.Siniestro;
import com.bootcamp.seguro.entity.Vehiculo;
import com.bootcamp.seguro.repository.SiniestroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiniestroService implements ISiniestroService {

    private final SiniestroRepository siniestroRepository;
    private final ModelMapper modelMapper;

    public SiniestroService(SiniestroRepository siniestroRepository, ModelMapper modelMapper) {
        this.siniestroRepository = siniestroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SiniestroDto findById(Long id) {
        Siniestro siniestro = siniestroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el sinietro."));
        return mapToSiniestroDto(siniestro);
    }

    @Override
    public List<SiniestroDto> findAll(SiniestroDto filter) {
        return siniestroRepository.findAll().stream()
                .map(this::mapToSiniestroDto)
                .collect(Collectors.toList());
    }

    @Override
    public SiniestroDto save(SiniestroDto modelDto) {
        return mapToSiniestroDto(siniestroRepository.save(mapToSiniestro(modelDto)));
    }

    @Override
    public SiniestroDto update(Long id, SiniestroDto modelDto) {
        Siniestro siniestro = siniestroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el sinietro."));
        modelMapper.map(mapToSiniestro(modelDto), siniestro);
        return mapToSiniestroDto(siniestroRepository.save(siniestro));
    }

    @Override
    public void delete(Long id) {
        siniestroRepository.deleteById(id);
    }

    private SiniestroDto mapToSiniestroDto(Siniestro siniestro){
        SiniestroDto siniestroDto = modelMapper.map(siniestro, SiniestroDto.class);
        siniestroDto.setVehiculoDenunciado(mapToVehiculoDto(siniestro.getVehiculoDenunciado()));
        return siniestroDto;
    }

    private Siniestro mapToSiniestro(SiniestroDto siniestroDto){
        Siniestro siniestro = modelMapper.map(siniestroDto, Siniestro.class);
        siniestro.setVehiculoDenunciado(mapToVehiculo(siniestroDto.getVehiculoDenunciado()));
        return siniestro;
    }

    private VehiculoDto mapToVehiculoDto(Vehiculo vehiculo){
        return modelMapper.map(vehiculo, VehiculoDto.class);
    }

    private Vehiculo mapToVehiculo(VehiculoDto vehiculo){
        return modelMapper.map(vehiculo, Vehiculo.class);
    }
}
