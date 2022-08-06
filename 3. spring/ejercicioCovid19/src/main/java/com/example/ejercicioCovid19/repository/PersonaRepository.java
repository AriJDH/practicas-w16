package com.example.ejercicioCovid19.repository;

import com.example.ejercicioCovid19.entities.Persona;

import java.util.*;

public class PersonaRepository {

    private static List<Persona> personas = new ArrayList<>();

    public static List<Persona> getPersonas(){
        personas.add(new Persona(1,"Samantha","Rios",25,SintomaRepository.findSintoma("Fiebre")));
        personas.add(new Persona(2,"Pablo","Hernandez",37,SintomaRepository.findSintoma("Tos")));
        personas.add(new Persona(3,"Luisa","Del Monte",68,SintomaRepository.findSintoma("Diarrea")));
        personas.add(new Persona(4,"Carolina","Ramirez",12,SintomaRepository.findSintoma("Dolor de cabeza")));
        personas.add(new Persona(5,"Antonio","Bustamante",70,SintomaRepository.findSintoma("Cansancio")));
        personas.add(new Persona(6,"Arturo","Lopez",41,null));

        return  personas;
    }
}
