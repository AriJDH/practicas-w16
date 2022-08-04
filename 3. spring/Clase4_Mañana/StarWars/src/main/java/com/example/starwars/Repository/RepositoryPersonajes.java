package com.example.starwars.Repository;

import com.example.starwars.Entity.Starwars;
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
public class RepositoryPersonajes {
    private static List<Starwars> personajes;

    public static List<Starwars> loadPersonajes(){
        File file = null;
        try {
            file = ResourceUtils.getFile("file:/Users/mnicoletta/Desktop/practicas-w16/3. spring/Clase4_Mañana/StarWars/src/main/resources/starwars.json");
        }catch  (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Starwars>> typeref = new TypeReference<List<Starwars>>() {};
        List<Starwars> personajes = null;
        try {
            personajes= objectMapper.readValue(file,typeref);
        }catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return personajes;
    }
}
