package com.example.demo.service;

import com.example.demo.dto.GetMatriculaMarcaModeloAutoDTO;
import com.example.demo.dto.GetPatenteAutoDTO;
import com.example.demo.dto.GetPatenteMarcaAutoDTO;
import com.example.demo.model.Auto;
import com.example.demo.repository.AutoRepository;
import com.example.demo.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoService implements IAutoService {

    private final AutoRepository autoRepository;

    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public GetPatenteAutoDTO getPatenteAuto(Long id) {
        Auto auto = autoRepository.getAutoById(id);
        return Mapper.toGetPatenteAutoDTO(auto);
    }

    @Override
    public List<GetPatenteAutoDTO> getPatentes() {
        List<GetPatenteAutoDTO> autos = autoRepository.getAutos().stream().map(x -> {
            return Mapper.toGetPatenteAutoDTO(x);
        }).collect(Collectors.toList());
        return autos;
    }

    @Override
    public List<GetPatenteMarcaAutoDTO> getPatenteMarcaOrderByAnioFabricacion() {
        List<GetPatenteMarcaAutoDTO> autos = autoRepository.getAutosOrderByAnioFabricacion().stream().map(x -> {
            return Mapper.toGetPatenteMarcaAutoDTO(x);
        }).collect(Collectors.toList());
        return autos;
    }

    @Override
    public List<GetMatriculaMarcaModeloAutoDTO> getPatenteMarcaModeloWithSiniestro() {
        List<GetMatriculaMarcaModeloAutoDTO> autos = autoRepository.getAutosWithSiniestrosOver10000().stream().map(x -> {
            return Mapper.toGetMatriculaMarcaModeloAutoDTO(x);
        }).collect(Collectors.toList());
        return autos;
    }
}
