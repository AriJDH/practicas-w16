package com.spring.personajes_star_wars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.personajes_star_wars.DTO.PersonajeDTO;
import com.spring.personajes_star_wars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajesDAOImpl implements IPersonajesDAO{

    private final List<Personaje> database;
    public PersonajesDAOImpl() {
        this.database = loadDataBase();
    }

    @Override
    public List<PersonajeDTO> getPersonajes() {

        PersonajeDTO per1 = new PersonajeDTO("Anakin Skywalker", 188, 84, "Male", "Tatooine", "Human");
        PersonajeDTO per2 = new PersonajeDTO("Luke Skywalker", 172, 77, "Male", "Tatooine", "Human");
        PersonajeDTO per3 = new PersonajeDTO("Darth Maul", 175, 80, "Male", "Dathomir", "Zabrak");
        PersonajeDTO per4 = new PersonajeDTO("Darth Vader", 202, 136, "Male", "Tatooine", "Human");

        List<PersonajeDTO> list = new ArrayList<>(Arrays.asList(per1, per2, per3, per4));

        return list;
    }

    @Override
    public List<Personaje> findAllByNameContains(String query) {
        return database.stream()
                .filter(character -> matchWith(query, character))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, Personaje personaje) {
        return personaje.getName().toUpperCase().contains(query.toUpperCase());
    }

    private List<Personaje> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
