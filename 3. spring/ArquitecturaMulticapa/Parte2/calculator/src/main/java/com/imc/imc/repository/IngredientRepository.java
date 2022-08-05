package com.imc.imc.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imc.imc.entity.IngredienteEntity;

@Repository
public class IngredientRepository implements IRepository{

    private final List<IngredienteEntity> ingredients;
    
    public IngredientRepository() {
        this.ingredients = loadData();
    }
    
    @Override
    public IngredienteEntity findByName(String name) {
        return ingredients.stream()
                .filter(i -> i.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean isIngredient(String name, IngredienteEntity ingredient) {
        return name.equals(ingredient.getName());
    }

    private List<IngredienteEntity> loadData(){

        File file = null;

        try{
            file = ResourceUtils.getFile("classpath:ingredients.json");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<IngredienteEntity>> typeRef = new TypeReference<>(){};
        List<IngredienteEntity> ingredientes = null;

        try{
            ingredientes = mapper.readValue(file, typeRef);
        }catch(IOException e){
            e.printStackTrace();
        }

        return ingredientes;

    }
}
