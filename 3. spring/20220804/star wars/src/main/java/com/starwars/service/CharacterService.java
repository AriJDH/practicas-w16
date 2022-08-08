package com.starwars.service;

import com.starwars.dto.CharacterDTO;
import com.starwars.entity.Character;
import com.starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<CharacterDTO> searchByName(String name) {
        return this.characterRepository.searchByName(name);
    }

    public List<CharacterDTO> getCharacters() {
        return this.characterRepository.getCharacters();
    }

    public void addCharacters(List<Character> characters) {
        this.characterRepository.addCharacters(characters);
    }

    public void addCharacter(Character character) {
        this.characterRepository.addCharacter(character);
    }
}
