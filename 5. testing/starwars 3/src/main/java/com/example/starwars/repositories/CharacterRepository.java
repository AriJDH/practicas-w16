package com.example.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.starwars.dto.CharacterDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.example.starwars.model.Character;

@Repository
public class CharacterRepository implements ICharacterRepository {
  private final List<Character> characters;

  public CharacterRepository () {
    this.characters  = loadDataBase();
  }

  @Override
  public List<Character> findAllByNameContains(String query) {
    return characters.stream()
        .filter(character -> character.nameContains(query))
        .collect(Collectors.toList());
  }

  private List<Character> loadDataBase() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:starwars_characters.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    TypeReference<List<Character>> typeRef = new TypeReference<>() {};
    List<Character> characters = null;
    try {
      characters = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return characters;
  }
}
