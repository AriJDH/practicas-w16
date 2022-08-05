package com.example.calculadoracalorias.Repository;

import com.example.calculadoracalorias.Entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RCalorias {
    private List<Ingrediente> platos;

    public List<Ingrediente> loadIngredientes(){
        File file = null;
        try {
            file = ResourceUtils.getFile("file:/Users/mnicoletta/Desktop/practicas-w16/3. spring/clase5_Mañana/CalculadoraCalorias/src/main/resources/food.json");
        }catch  (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeref = new TypeReference<List<Ingrediente>>() {};
        List<Ingrediente> platos = null;
        try {
            platos= objectMapper.readValue(file,typeref);
        }catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return platos;
    }

}
