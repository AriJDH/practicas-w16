package com.starwars.starwarsexercise.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwarsexercise.model.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository {

    private List<Personaje> personajes = new ArrayList<>();

    public PersonajeRepository() throws IOException {
        cargarPersonajes();
    }

    public List<Personaje> findPersonajesByName(String name){
        List<Personaje> listaPersonajes = personajes.stream().filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        return listaPersonajes;
    }

    public void cargarPersonajes() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try{
            File starwarsJson = ResourceUtils.getFile("classpath:starwars.json");
            personajes = mapper.readValue(starwarsJson, new TypeReference<List<Personaje>>() {});
        } catch(Exception ex) {
            System.out.println("No existe el personaje: " + ex.getMessage());
        }


    }

}
