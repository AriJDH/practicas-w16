package com.meli.calculador.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calculador.entity.Ingredientes;
import com.meli.calculador.entity.Plato;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaloriesRespository implements ICaloriesRepository {


    @Override
    public List<Ingredientes> getIngredientes() {

        ObjectMapper mapper = new ObjectMapper();
        File archivoJson = null;
        List<Ingredientes> ingredientes = new ArrayList<>();

        try {
            archivoJson = ResourceUtils.getFile("classpath:food.json");
            ingredientes = mapper.readValue(archivoJson, new TypeReference<List<Ingredientes>>() {
            });
        } catch (Exception ex) {
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
        return ingredientes;
    }

    @Override
    public List<Plato> getPlato() {

        return new ArrayList<>(Arrays.asList(new Plato("Milanesa", 100, getIngredientes()), new Plato("Arroz con pollo", 10, getIngredientes())));
    }


}
