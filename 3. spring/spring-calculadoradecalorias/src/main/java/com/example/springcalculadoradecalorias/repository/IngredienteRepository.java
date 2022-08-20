package com.example.springcalculadoradecalorias.repository;

import com.example.springcalculadoradecalorias.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredienteRepository {
    private List<Ingrediente> ingredientes;

    public IngredienteRepository() {
        this.loadIngredientes();
    }

    public List<Ingrediente> getAll() {
        return this.ingredientes;
    }

    private void loadIngredientes() {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {
        };

        try {
            file = ResourceUtils.getFile("classpath:food.json");
            this.ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
