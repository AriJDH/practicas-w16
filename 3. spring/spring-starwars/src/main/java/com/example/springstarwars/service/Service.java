package com.example.springstarwars.service;

import com.example.springstarwars.dto.RequestPersonajeDTO;
import com.example.springstarwars.dto.ResponsePersonajeDTO;
import com.example.springstarwars.repository.PersonajeRepository;
import com.example.springstarwars.utilis.PersonajeUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private PersonajeRepository repository;
    @Autowired
    private PersonajeUtils utils;

    public void cargarPersonajes(List<RequestPersonajeDTO> body) {
        this.repository.cargarPersonajes(body);
    }

    public List<ResponsePersonajeDTO> getPersonaje(String name) {
        return this.repository.getPersonajeDao().getPersonajes().stream()
                    .filter(personaje -> personaje.getName().contains(name))
                    .map(personaje -> this.utils.converToPersonajeDTO(personaje)).collect(Collectors.toList());
    }
}
