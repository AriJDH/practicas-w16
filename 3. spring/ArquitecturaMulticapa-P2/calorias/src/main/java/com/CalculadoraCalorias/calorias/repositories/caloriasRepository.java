package com.CalculadoraCalorias.calorias.repositories;

import com.CalculadoraCalorias.calorias.DTO.IngredientesDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository

public class caloriasRepository {

    private final List<IngredientesDTO> ingredientes;

    public caloriasRepository() {
        this.ingredientes = loadDataBase();
    }


    public List<IngredientesDTO> loadDataBase() {

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientesDTO>> typeRef = new TypeReference<>() {
        };

        List<IngredientesDTO> ingredientes = null;

        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

}
