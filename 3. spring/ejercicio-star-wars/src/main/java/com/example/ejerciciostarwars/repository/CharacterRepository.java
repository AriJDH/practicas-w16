package com.example.ejerciciostarwars.repository;

import com.example.ejerciciostarwars.entity.Character;

import java.util.List;

public interface CharacterRepository {

    List<Character> getCharactersNamedLike(String name);

    void save(List<Character> characters);
}
