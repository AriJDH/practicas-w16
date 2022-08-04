package com.example.ejerciciostarwars.service;

import com.example.ejerciciostarwars.dto.CharacterDTO;
import com.example.ejerciciostarwars.entity.Character;
import com.example.ejerciciostarwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public void saveCharacters(List<Character> characters) {
        characterRepository.save(characters);
    }

    public List<CharacterDTO> charactersNamedLike(String aName) {
        return characterRepository.getCharactersNamedLike(aName).stream().map(CharacterDTO::new).collect(Collectors.toList());
    }
}
