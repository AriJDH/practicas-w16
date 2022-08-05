package com.tomas.calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomas.calorias.dto.IngredienteDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepositoryImpl implements IngredienteRepository {


    private List<IngredienteDTO> cargarDatos() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<>() {};
        List<IngredienteDTO> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    @Override
    public IngredienteDTO encontrarIngrediente(String name) {
        Optional<IngredienteDTO> ingredientDTO = cargarDatos().stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .findFirst();

        if(ingredientDTO.isPresent()) return ingredientDTO.get();
        return null;
    }

    @Override
    public IngredienteDTO encontrarMayorCaloria() {

        Optional<IngredienteDTO> ingredientDTO = cargarDatos().stream()
                .sorted(Comparator.comparingInt(IngredienteDTO::getCalories).reversed())
                .findFirst();

        if(ingredientDTO.isPresent()) return ingredientDTO.get();
        return null;
    }
}
