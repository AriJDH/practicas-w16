package com.bootcamp.practico.service;


import com.bootcamp.practico.dto.RequestPersonajeDTO;
import com.bootcamp.practico.dto.ResponsePersonajeDto;
import com.bootcamp.practico.repository.PersonajeRepository;
import com.bootcamp.practico.utilis.PersonajeUtils;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    PersonajeRepository repository;
    @Autowired
    private PersonajeUtils utils;


    public void cargaPersonajes(List<RequestPersonajeDTO> body) {
        repository.cargarPersonaje(body);

    }

    public List<ResponsePersonajeDto> getPersonaje(String name) {
        return repository.getPersonajeDao().getPersonajes().stream()
                .filter(personaje -> personaje.getName().contains(name))
                .map(personaje -> utils.converToPersonajeDTO(personaje)).collect(Collectors.toList());

    }
}
