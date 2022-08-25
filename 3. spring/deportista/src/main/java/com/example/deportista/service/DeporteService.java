package com.example.deportista.service;

import com.example.deportista.dto.DeporteDTO;
import com.example.deportista.dto.PersonaDTO;
import com.example.deportista.entity.Deporte;
import com.example.deportista.repository.DeporteRespository;
import com.example.deportista.repository.PersonaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DeporteService implements IDeporteService{

    DeporteRespository deporteRespository = new DeporteRespository();
    PersonaRepository personaRepository = new PersonaRepository();
    @Override
    public List<DeporteDTO> getAll() {
        return deporteRespository.getAll().stream()
                .map(deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel()))
                .collect(Collectors.toList());
    }

    @Override
    public DeporteDTO getByName(String name) {
        return new DeporteDTO(deporteRespository.getDeporte(name).getNombre(), deporteRespository.getDeporte(name).getNivel());

    }

    @Override
    public List<PersonaDTO> getPersonas() {
        return personaRepository.getAll().stream()
                .filter(persona -> persona.getDeporte()!=null)
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte()))
                .collect(Collectors.toList());
    }
}
