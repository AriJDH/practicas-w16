package com.bootcamp.aplication.repository;

import com.bootcamp.aplication.entity.Food;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class CalculoCaloriasRepository {

    private List<Food> foodList = new ArrayList<>();

    public CalculoCaloriasRepository() {
        this.foodList = loadFood();
    }

    private List<Food> loadFood() {

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Food>> typeRef = new TypeReference<>() {
        };
        List<Food> foods = null;

        try {
            foods = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foods;
    }
}
