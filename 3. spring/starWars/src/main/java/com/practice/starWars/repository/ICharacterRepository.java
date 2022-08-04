package com.practice.starWars.repository;

import com.practice.starWars.model.CharacterStarWars;

import java.util.List;

public interface ICharacterRepository {

    List<CharacterStarWars> listCharactersFilterByName(String name);
}
