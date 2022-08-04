package com.bootcamp.starwarsexcercise.service;

import com.bootcamp.starwarsexcercise.dto.CharacterDto;
import com.bootcamp.starwarsexcercise.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class FindService implements FindServiceInterface {
    @Autowired
    CharacterRepository repo;


    @Override
    public List<CharacterDto> findByName(String name) {
      return  repo.getAllCharacters().stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .map(character -> new CharacterDto(character.getName(), character.getHeight(), character.getMass(), character.getGender(), character.getHomeWorld(), character.getSpecies()))
                .collect(Collectors.toList());
    }
}
