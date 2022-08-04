package com.spring.StarWars.service;

import com.spring.StarWars.dto.PersonajeDTO;
import com.spring.StarWars.entitie.Personaje;
import com.spring.StarWars.repositorie.PersonajeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PersonajeService {
    private final PersonajeRepo personajeRepo = new PersonajeRepo();
    private final List<Personaje> characterList = personajeRepo.loadCharacters();

    public List<PersonajeDTO> searchPersonaje(String name){

        return characterList.stream().filter(p -> p.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
                .map(personaje -> new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()))
                .collect(Collectors.toList());
    }

}
