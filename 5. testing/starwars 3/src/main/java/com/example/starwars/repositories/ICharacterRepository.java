package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.model.Character;

import java.util.List;

public interface ICharacterRepository {
  List<Character> findAllByNameContains(String query);
}
