package com.bootcamp.aplicacion.repo;

import com.bootcamp.aplicacion.entities.Deporte;
import com.bootcamp.aplicacion.entities.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Personas {


    private static final List<Persona> personas = new ArrayList<>(Arrays.asList(
            new Persona("Claudio", "Antolin", 39, Deportes.deportes.get(0)),
            new Persona("Felipe", "Barraza", 40, Deportes.deportes.get(1)),
            new Persona("Alvaro", "Matus", 42, null)
    ));

    public static List<Persona> listarPersonas(){
        return personas;
    }
}
