package com.bootcamp.automoviles.services;

import com.bootcamp.automoviles.dto.SiniestroDTO;
import com.bootcamp.automoviles.dto.Siniestro_DTO;
import com.bootcamp.automoviles.entities.Siniestros;
import com.bootcamp.automoviles.repositories.ISiniestroRepository;
import com.bootcamp.automoviles.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiniestroService implements ISiniestroService{

    @Autowired
    private ISiniestroRepository siniestroRepository;

    @Override
    public Siniestro_DTO create(Siniestro_DTO siniestroDTO) {
        Siniestros newSiniestro = ModelMapper.parseFromSieniestroDTO(siniestroDTO);
        return ModelMapper.parseFromSiniestro(siniestroRepository.save(newSiniestro));
    }

    @Override
    public List<SiniestroDTO> find() {
        return siniestroRepository.findAll()
                .stream()
                .map(ModelMapper::parseFromSiniestros)
                .collect(Collectors.toList());
    }
}
