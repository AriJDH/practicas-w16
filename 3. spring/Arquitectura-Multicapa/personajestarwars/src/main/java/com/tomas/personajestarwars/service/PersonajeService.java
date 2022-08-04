package com.tomas.personajestarwars.service;

import com.tomas.personajestarwars.dto.PersonajeDto;
import com.tomas.personajestarwars.entity.Personaje;
import com.tomas.personajestarwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    @Autowired
    PersonajeRepository repository;

    @Override
    public List<PersonajeDto> listarPersonaje(String nombre) {

        return repository.obtenerListaFiltrada(nombre)
                .stream()
                .map(x-> new PersonajeDto(x.getName(),x.getHeight(),x.getMass(),x.getGender(),x.getHomeWorld(),x.getSpecies()))
                .collect(Collectors.toList());
    }

}
