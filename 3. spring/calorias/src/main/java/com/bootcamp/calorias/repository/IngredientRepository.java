package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.entity.Ingredient;
import com.bootcamp.calorias.utils.Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepository implements IRepository<Ingredient> {

    private List<Ingredient> ingredients;

    private List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    public IngredientRepository() {
        this.ingredients = loadDataBase();
    }

    public List<Ingredient> getAll(){
        return this.ingredients;
    }
}
