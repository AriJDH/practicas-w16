package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ParseJson {

    public List<Ingredient> goUpIngredients() {
        try {
            Reader reader = new FileReader("src/main/resources/3. food.json");

            ObjectMapper mapper = new ObjectMapper();
            List<Ingredient> ingredients = mapper.readValue(reader, new TypeReference<List<Ingredient>>() {
            });
            return ingredients;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
