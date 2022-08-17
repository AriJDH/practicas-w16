package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class Personajes {

    //Creación de una lista de DTO de Personajes como parámetro de la clase
    private final List<PersonajeDTO> personajes;

    //Constructor de la clase Personajes, que se pobla con el archivo .json entregado
    public Personajes(){
        this.personajes = cargarPersonajes();
    }

    /* Método que extrae la data del archivo .json y la carga en una lista de personajes,
    utilizando la librería 'Jackson' */
    public List<PersonajeDTO> cargarPersonajes(){
        File archivo = null;
        try{
            archivo = ResourceUtils.getFile("classpath:starwars.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDTO>> typeReference = new TypeReference<>() {};
        List<PersonajeDTO> personajes = null;
        try {
            personajes = objectMapper.readValue(archivo, typeReference);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return personajes;
    }

    //Método para listar personajes de acuerdo al input señalado en la URL
    public List<PersonajeDTO> encontrarPersonajes(String name){
        return personajes.stream()
                .filter(personajeDTO -> personajeDTO.getName().contains(name))
                .collect(Collectors.toList());
    }
}
