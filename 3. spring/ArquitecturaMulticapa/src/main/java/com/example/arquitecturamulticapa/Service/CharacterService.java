package com.example.arquitecturamulticapa.Service;

import com.example.arquitecturamulticapa.DTO.CharacterDTO;
import com.example.arquitecturamulticapa.Entity.Character;
import com.example.arquitecturamulticapa.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CharacterService {


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
