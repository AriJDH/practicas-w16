package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.dto.CharacterDto;
import com.bootcamp.starwars.model.Character;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class CharacterRepository {

    List<CharacterDto> characterDtos;
    List<Character> charactersList;

    public CharacterRepository(){
        this.charactersList = loadCharacter();
    }

    private List<Character> loadCharacter(){

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starWars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<Character> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }


    public List<CharacterDto> findByName(String name){

        List<Character> characters = charactersList
                .stream()
                .filter(characterDto -> characterDto.getName().contains(name))
                .collect(Collectors.toList());

        return characterDtos(characters);
    }
    public List<CharacterDto> findAllData(){

        return characterDtos(charactersList);
    }







    public List<CharacterDto> characterDtos(List<Character> characters){


        List<CharacterDto> characterDtos2 = characters.stream().map(character->{
            CharacterDto characterDto = new CharacterDto();
            characterDto.setName(character.getName());
            characterDto.setMass(character.getMass());
            characterDto.setSpecies(character.getSpecies());
            characterDto.setHeight(character.getHeight());
            characterDto.setHomeWorld(character.getHomeWorld());
            characterDto.setGender(character.getGender());
            return characterDto;
        }).collect(Collectors.toList());

        return characterDtos2;
    }
}
