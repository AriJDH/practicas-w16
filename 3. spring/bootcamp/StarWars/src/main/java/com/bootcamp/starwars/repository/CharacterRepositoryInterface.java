package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Character;

import java.util.List;

public interface CharacterRepositoryInterface {

    List<Character> getAllCharacters();
}
