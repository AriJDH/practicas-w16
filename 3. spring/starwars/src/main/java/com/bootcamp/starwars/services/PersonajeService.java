package com.bootcamp.starwars.services;

import com.bootcamp.starwars.dtos.PersonajeDTO;
import com.bootcamp.starwars.models.Personaje;
import com.bootcamp.starwars.repositories.PersonajeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {

    PersonajeRepo personajeRepo = new PersonajeRepo();
    List<Personaje> personajes = personajeRepo.loadCharacters();

    public List<PersonajeDTO> searchCharacter(String name){

        return personajes.stream().filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .map(personaje -> new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeWorld(), personaje.getSpecies()))
                .collect(Collectors.toList());
    }
}
