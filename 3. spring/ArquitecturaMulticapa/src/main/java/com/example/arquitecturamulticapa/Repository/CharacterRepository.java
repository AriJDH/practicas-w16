package com.example.arquitecturamulticapa.Repository;

import com.example.arquitecturamulticapa.DTO.CharacterDTO;
import com.example.arquitecturamulticapa.Entity.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterRepository {
    private List<Character> characters = new ArrayList<>();

    public void addCharacters(List<Character> characters) {
        this.characters.addAll(characters);
    }

    public void addCharacter(Character character) {
        this.characters.add(character);
    }

    public List<CharacterDTO> getCharacters() {
        return this.characters.stream()
                .map(character -> new CharacterDTO(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeWorld(),
                        character.getSpecies()
                ))
                .collect(Collectors.toList());
    }

    public List<CharacterDTO> searchByName(String name) {
        return this.characters.stream()
                .filter(character -> character.getName().toUpperCase().contains(name.toUpperCase()))
                .map(character -> new CharacterDTO(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeWorld(),
                        character.getSpecies()
                ))
                .collect(Collectors.toList());
    }

}
