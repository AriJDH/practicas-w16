package com.example.ejercicioproyectostarwars.service;

import com.example.ejercicioproyectostarwars.dto.PersonajeDto;
import com.example.ejercicioproyectostarwars.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {
    @Autowired
    IPersonajeRepository repository;

    @Override
    public List<PersonajeDto> findLisWithWord(String param) {
        return repository.obtenerListaFiltrada(param).stream().map(x-> new PersonajeDto(x.getName(),x.getHeight(),x.getMass(),x.getGender(),x.getHomeWorld(),x.getSpecies())).collect(Collectors.toList());
    }
}
