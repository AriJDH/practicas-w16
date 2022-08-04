package com.tomas.personajestarwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomas.personajestarwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository {

    private final List<Personaje> datos;

    public PersonajeRepository(){
        this.datos = cargarDatos();
    }

    public List<Personaje> cargarDatos(){
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch(Exception e){
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


    @Override
    public List<Personaje> obtenerListaFiltrada(String nombre) {
        return datos.stream()
                .filter(x->x.getName().contains(nombre))
                .collect(Collectors.toList());
    }


}
