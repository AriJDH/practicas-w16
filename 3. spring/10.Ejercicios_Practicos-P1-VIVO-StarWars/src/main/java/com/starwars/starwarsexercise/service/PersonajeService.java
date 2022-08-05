package com.starwars.starwarsexercise.service;

import com.starwars.starwarsexercise.dto.PersonajeDto;
import com.starwars.starwarsexercise.model.Personaje;
import com.starwars.starwarsexercise.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {

    @Autowired
    PersonajeRepository personajeRepository;

    public List<PersonajeDto> findPersonajesByName(String name){
        List<Personaje> listaPersonajes = personajeRepository.findPersonajesByName(name);
        return listaPersonajes.stream().map(personaje -> {
            PersonajeDto personajeDto = new PersonajeDto();
            personajeDto.setName(personaje.getName());
            personajeDto.setGender(personaje.getGender());
            personajeDto.setHeight(personaje.getHeight());
            personajeDto.setHomeworld(personaje.getHomeworld());
            personajeDto.setMass(personaje.getMass());
            personajeDto.setSpecies(personaje.getSpecies());
            return personajeDto;
        }).collect(Collectors.toList());
    }

}
