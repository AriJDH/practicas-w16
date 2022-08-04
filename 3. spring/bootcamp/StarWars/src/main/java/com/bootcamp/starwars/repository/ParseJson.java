package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ParseJson {

    public List<Character> returnCharacters() {

        try (Reader reader = new FileReader("/Users/marmejia/Documents/bootcamp/practicas-w16/3. spring/bootcamp/StarWars/src/main/resources/starwars.json")) {
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
