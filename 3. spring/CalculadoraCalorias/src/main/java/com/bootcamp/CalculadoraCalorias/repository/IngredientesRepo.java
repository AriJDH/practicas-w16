package com.bootcamp.CalculadoraCalorias.repository;

import com.bootcamp.CalculadoraCalorias.dto.IngredienteDTO;
import com.bootcamp.CalculadoraCalorias.entities.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class IngredientesRepo {
    public List<Ingrediente> listaDeIngredientes;

    public IngredientesRepo() {
        this.listaDeIngredientes = cargarIngredientes().stream().collect(Collectors.toList());
    }

    private List<Ingrediente> cargarIngredientes(){
        File archivo = null;
        try{
            archivo = ResourceUtils.getFile("classpath:food.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeReference = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(archivo, typeReference);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return ingredientes;
    }

    public List<Ingrediente> listaIngredientes(String[] ingredientes) {
        List<Ingrediente> salidaIngredientes = new ArrayList<>();
        for (final String ingr : ingredientes) {
            Ingrediente ingrediente = listaDeIngredientes.stream()
                    .filter(value -> value.getName().equalsIgnoreCase(ingr))
                    .findFirst().get();
            salidaIngredientes.add(ingrediente);
        }
        return salidaIngredientes;
    }

    public int totalCalorias(List<Ingrediente> ingredientes){
        return ingredientes.stream().mapToInt(value -> value.getCalories()).sum();
    }

    public String masCalorico(List<Ingrediente> ingredientes){
        String salida = "";
        OptionalInt valorMaximo = ingredientes.stream().mapToInt(value -> value.getCalories()).max();
        for (Ingrediente ingr : ingredientes){
            if (valorMaximo.getAsInt() == ingr.getCalories()){
                salida = ingr.getName();
            }
        }
        return salida;
    }
}
