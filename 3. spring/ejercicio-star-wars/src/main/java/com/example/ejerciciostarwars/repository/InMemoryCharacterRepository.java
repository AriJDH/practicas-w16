package com.example.ejerciciostarwars.repository;

import com.example.ejerciciostarwars.entity.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class InMemoryCharacterRepository implements CharacterRepository{

    private List<Character> characters;

    public InMemoryCharacterRepository(){
        characters = new ArrayList<>();
    }

    @Override
    public List<Character> getCharactersNamedLike(String name) {
        return characters.stream().filter(character -> character.isNamedLike(name.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public void save(List<Character> characters) {
        this.characters.addAll(characters);
    }
}
