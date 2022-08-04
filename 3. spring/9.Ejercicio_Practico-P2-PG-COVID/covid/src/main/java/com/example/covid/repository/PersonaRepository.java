package com.example.covid.repository;

import com.example.covid.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class PersonaRepository {
    private static List<Persona> personas = new ArrayList<>();

    public static List<Persona> getPersonas(){
        personas.add(new Persona("12244", "Paola", "Gomez", 24, SintomaRepository.findSintoma("Fiebre")));
        personas.add(new Persona("12345", "Carlota", "Duran", 50, SintomaRepository.findSintoma("Tos")));
        personas.add(new Persona("45678", "Sara", "Gutierrez", 32, SintomaRepository.findSintoma("Cansancio")));
        personas.add(new Persona("65432", "Arturo", "Ramirez", 79, SintomaRepository.findSintoma("Fiebre")));
        return personas;
    }
}
