package com.example.starwars.repository;

import com.example.starwars.model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class ParseJson {

    public List<Character> returnCharacters() {
        try {
            Reader reader = new FileReader("src/main/resources/starwars.json");

            ObjectMapper mapper = new ObjectMapper();
            List<Character> characters = mapper.readValue(reader, new TypeReference<List<Character>>() {
            });
            return characters;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
