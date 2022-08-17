package com.bootcamp.ejerciciospracticosp2vivo.repository;

import com.bootcamp.ejerciciospracticosp2vivo.entity.Ingredient;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Repository
public class IngredientRepository implements  IIngredientRepository{

    private  List<Ingredient> loadIngredient(){
        try{
            Reader reader = new FileReader("/Users/anroa/Documents/RepositorioEvidencias/practicas-w16/3. spring/EjerciciosPracticosP2Vivo/src/main/resources/Food.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Ingredient> ingredients = mapper.readValue(reader, new TypeReference<List<Ingredient>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return List.of();
    }



    @Override
    public List<Ingredient> getAll() {
        return loadIngredient();
    }
}
