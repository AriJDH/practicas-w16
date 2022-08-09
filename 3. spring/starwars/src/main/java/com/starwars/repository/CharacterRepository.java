package com.starwars.repository;

import com.starwars.dto.CharacterDTO;
import com.starwars.entity.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements IRepository {
    private List<Character> characters = new ArrayList<>();

    @Override
    public void addCharacters(List<Character> characters) {
        this.characters.addAll(characters);
    }
    @Override
    public void addCharacter(Character character) {
        this.characters.add(character);
    }
    @Override
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
    @Override
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
