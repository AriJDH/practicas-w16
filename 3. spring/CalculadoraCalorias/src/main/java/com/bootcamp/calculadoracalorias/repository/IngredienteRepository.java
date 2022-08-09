package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

@Repository
public class IngredienteRepository implements IIngredienteRepository{
    private List<Ingrediente> ingredienteList;

    public IngredienteRepository(){
        this.ingredienteList = loadData();
    }

    public Ingrediente buscarIngrediente(String name){
        try{
            return ingredienteList.stream().filter(ingrediente -> ingrediente.getName().equalsIgnoreCase(name)).findFirst().get();
        } catch (Exception ex){
            return null;
        }
    }

    private List<Ingrediente> loadData(){
        ObjectMapper mapper = new ObjectMapper();
        File archivoJson = null;
        try {
            archivoJson = ResourceUtils.getFile("classpath:food.json");
            return mapper.readValue(archivoJson, new TypeReference<List<Ingrediente>>() {
            });
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
            return null;
        }
    }
}
