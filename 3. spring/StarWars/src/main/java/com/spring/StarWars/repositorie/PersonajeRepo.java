package com.spring.StarWars.repositorie;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.StarWars.entitie.Personaje;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PersonajeRepo {

    public PersonajeRepo() {

    }

    public List<Personaje> loadCharacters (){
        File jsonCharacters = null;
        try {
            jsonCharacters = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(jsonCharacters, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
