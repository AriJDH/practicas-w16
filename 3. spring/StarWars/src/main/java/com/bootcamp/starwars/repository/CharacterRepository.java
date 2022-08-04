package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository {
    private List<Character> characters = new ArrayList<Character>();

    public CharacterRepository() {
        ObjectMapper mapper = new ObjectMapper();
        File archivoJson = null;
        try {
            archivoJson = ResourceUtils.getFile("classpath:starwars.json");
            characters = mapper.readValue(archivoJson, new TypeReference<List<Character>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

    public List<Character> findCharacterByName(String name){
        return characters.stream().filter(character -> character.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }
}
