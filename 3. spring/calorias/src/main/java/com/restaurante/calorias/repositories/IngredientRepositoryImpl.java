package com.restaurante.calorias.repositories;

import com.restaurante.calorias.dto.IngredientDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {


    private List<IngredientDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>() {};
        List<IngredientDTO> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    @Override
    public IngredientDTO findIngredientByName(String name) {
        Optional<IngredientDTO> ingredientDTO = loadDataBase().stream().filter(i -> i.getName().equalsIgnoreCase(name)).findFirst();
        if(ingredientDTO.isPresent()) return ingredientDTO.get();
        return null;
    }

    @Override
    public IngredientDTO findMostCaloric() {
        Optional<IngredientDTO> ingredientDTO = loadDataBase().stream().sorted(Comparator.comparingInt(IngredientDTO::getCalories).reversed()).findFirst();

        if(ingredientDTO.isPresent()) return ingredientDTO.get();
        return null;
    }
}
