package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.response.PersonajeDTO;
import com.bootcamp.starwars.model.Personaje;
import com.bootcamp.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    @Autowired
    PersonajeRepository personajeRepository;


    @Override
    public List<PersonajeDTO> findPersonajeByName(String name) {
        List<Personaje> personajeList = personajeRepository.findPersonajeByName(name);
        return personajeList.stream().map(personaje -> {
            PersonajeDTO personajeDTO = new PersonajeDTO();
            personajeDTO.setName(personaje.getName());
            personajeDTO.setGender(personaje.getGender());
            personajeDTO.setHeight(personaje.getHeight());
            personajeDTO.setHomeworld(personaje.getHomeworld());
            personajeDTO.setMass(personaje.getMass());
            personajeDTO.setSpecies(personaje.getSpecies());
            return personajeDTO;
        }).collect(Collectors.toList());
    }
}
