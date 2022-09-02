package com.example.siniestros.service;

import com.example.siniestros.controller.SiniestroDto;
import com.example.siniestros.dto.PatenteDto;
import com.example.siniestros.dto.PatenteMarcaDto;
import com.example.siniestros.dto.VehiculoDto;
import com.example.siniestros.model.Siniestro;
import com.example.siniestros.model.Vehiculo;
import com.example.siniestros.repository.ISiniestroRepository;
import com.example.siniestros.repository.IVehiculoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

    @Autowired
    private IVehiculoRepository iVehiculoRepository;

    @Autowired
    private ISiniestroRepository iSiniestroRepository;

    private ModelMapper mapper;

    public VehiculoServiceImpl() {
        this.mapper = new ModelMapper();
    }

    @Override
    public List<PatenteDto> findAllPantentes() {
        return iVehiculoRepository.findAllPatentes().stream()
                .map(PatenteDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatenteMarcaDto> findAllPatentesAndMarcas() {
        return iVehiculoRepository.findAllPatentesAndMarcas();
    }

    @Override
    public Vehiculo createVehiculo(VehiculoDto vehiculoDto) {
        return iVehiculoRepository.save(mapper.map(vehiculoDto, Vehiculo.class));
    }

    @Override
    public Object createSiniestro(SiniestroDto siniestroDto) {
        return iSiniestroRepository.save(mapper.map(siniestroDto, Siniestro.class));
    }

    @Override
    public List<PatenteDto> findAllPatentesWithMoreThan4Ruedas() {
        return iVehiculoRepository.findAllPatentesWithMoreThanFourTuedasThisYear()
                .stream()
                .map(x->new PatenteDto(x))
                .collect(Collectors.toList());
    }
}
