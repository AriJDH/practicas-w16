package com.bootcamp.covid.services;

import com.bootcamp.covid.DTO.PersonaDTO;
import com.bootcamp.covid.DTO.RiesgoDTO;
import com.bootcamp.covid.DTO.SintomaDTO;
import com.bootcamp.covid.model.Sintoma;
import com.bootcamp.covid.repository.ISintomasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SintomasServices implements ISintomasServices{
    @Autowired
    ISintomasRepository iSintomasRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public List<SintomaDTO> getAllSintomas() {
        return iSintomasRepository.getAllSintomas().stream()
                .map(sintoma -> mapper.map(sintoma, SintomaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonaDTO> getAllPersonas() {
        return iSintomasRepository.getAllPersonas().stream()
                .map(persona -> mapper.map(persona, PersonaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SintomaDTO> getSintomaByName(String name) {
        return iSintomasRepository.getSintomaByName(name).stream()
                .map(sintoma -> mapper.map(sintoma, SintomaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RiesgoDTO> listaGrupoDeRiesgo() {
        return iSintomasRepository.getGrupoDeRiesgo().stream()
                .map(riesgo -> mapper.map(riesgo, RiesgoDTO.class))
                //.map(sintoma-> mapper.map(sintoma,SintomaDTO.class))
                //OJO NO ME SALE LA LISTA
                .collect(Collectors.toList());
    }

}
