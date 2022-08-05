package com.bootcamp.ejerciciorestaurante.repository;

import com.bootcamp.ejerciciorestaurante.dto.IngredientsDto;
import com.bootcamp.ejerciciorestaurante.entities.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;



@Setter
@Getter
@Repository
public class FoodRepository {

    private List<Ingredient> ingredients;

    public FoodRepository(){
        this.ingredients = loadDataBase();
    }

    private List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {
        };
        List<Ingredient> ingredient = null;
        try {
            ingredient = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredient;
    }
}
