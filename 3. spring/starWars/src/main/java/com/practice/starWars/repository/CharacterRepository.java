package com.practice.starWars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.starWars.model.CharacterStarWars;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterRepository implements ICharacterRepository{

    @Override
    public List<CharacterStarWars> listCharactersFilterByName(String name) {

        return loadSeed().stream().filter(x -> x.getName().contains(name)).collect(Collectors.toList());
    }


    private List<CharacterStarWars> loadSeed() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:seedStarWars/starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterStarWars>> typeRef = new TypeReference<>() {};
        List<CharacterStarWars> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
