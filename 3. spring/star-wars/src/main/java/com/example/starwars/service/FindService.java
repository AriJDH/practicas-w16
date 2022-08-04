package com.example.starwars.service;

import com.example.starwars.dto.CharacterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.starwars.repository.CharacterRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindService implements FindServiceInterface {
    @Autowired
    CharacterRepository repo;

    @Override
    public List<CharacterDto> findByName(String name) {
        return repo.getAllCharacters().stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .map(character -> new CharacterDto(character.getName(), character.getHeight(), character.getMass(), character.getGender(), character.getHomeWorld(), character.getSpecies()))
                .collect(Collectors.toList());
    }
}
