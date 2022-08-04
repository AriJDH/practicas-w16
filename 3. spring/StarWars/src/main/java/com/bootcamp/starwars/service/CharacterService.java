package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.response.CharacterDTO;
import com.bootcamp.starwars.model.Character;
import com.bootcamp.starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService{
    @Autowired
    CharacterRepository repository;

    @Override
    public List<CharacterDTO> findCharacterByName(String name) {
        List<Character> matchingNameCharacterList = repository.findCharacterByName(name);
        return matchingNameCharacterList.stream().map(character -> {
            CharacterDTO characterDTO = new CharacterDTO();
            characterDTO.setName(character.getName());
            characterDTO.setHeight(character.getHeight());
            characterDTO.setMass(character.getMass());
            characterDTO.setGender(character.getGender());
            characterDTO.setHomeworld(character.getHomeworld());
            characterDTO.setSpecies(characterDTO.getSpecies());

            return characterDTO;
        }).collect(Collectors.toList());

    }
}
