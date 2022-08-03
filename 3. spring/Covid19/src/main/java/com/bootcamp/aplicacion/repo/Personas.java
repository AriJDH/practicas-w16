package com.bootcamp.aplicacion.repo;

import com.bootcamp.aplicacion.entities.Persona;
import com.bootcamp.aplicacion.entities.Sintoma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Personas {

    public static final List<Persona> personas = new ArrayList<>(Arrays.asList(
            new Persona("031", "Claudio", "Antolin", 39, Sintomas.sintomasLeves),
            new Persona("032", "Lonchi", "Belén", 38, Sintomas.sintomasLeves),
            new Persona("033", "Georgina", "Muñoz", 64, null),
            new Persona("034", "Carlos", "Bustos", 74, Sintomas.sintomasGraves)
    ));

    public static List<Persona> listarPersonasConSintomas(){
        return personas;
    }

}
