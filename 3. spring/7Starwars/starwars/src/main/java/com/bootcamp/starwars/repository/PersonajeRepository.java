package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Personaje;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository {

    private List<Personaje> personajes = new ArrayList<>();

    public PersonajeRepository() throws IOException {
        cargarLista();
        System.out.println(personajes);
    }

    public List<Personaje> findPersonajeByName(String name){
        List<Personaje> lista = personajes.stream().filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        return lista;
    }


    public void cargarLista() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File archivoJson = null;
        try {
            archivoJson = ResourceUtils.getFile("classpath:starwars.json");
            personajes = mapper.readValue(archivoJson, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }



}
