package com.starwars.app.service;

import com.starwars.app.dto.CharacterDTO;
import com.starwars.app.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterDTO> find(String name){
        return characterRepository.findCharacter(name);
    }
}
