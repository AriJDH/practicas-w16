package com.starwars.starwars.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.starwars.starwars.repository.CharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.entity.Personaje;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<PersonajeDTO> findAllByNameContains(String name) {
        List<Personaje> characters = characterRepository.findAllByNameContains(name);
        List<PersonajeDTO> charactersDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        
        characters.forEach(
            character -> {
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                charactersDTO.add(mapper.convertValue(character, PersonajeDTO.class));
            }
        );

        return charactersDTO;
    }
}
