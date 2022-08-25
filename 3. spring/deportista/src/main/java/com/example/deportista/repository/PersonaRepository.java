package com.example.deportista.repository;

import com.example.deportista.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository implements Repository<Persona> {

    private List<Persona> personas = new ArrayList<>();

    @Override
    public List<Persona> getAll() {
        personas.add(new Persona("Laura","Mendoza",25,"Karate"));
        personas.add(new Persona("Samuel","Correa",21,"Volibol"));
        personas.add(new Persona("Antonio","Juarez",15,null));
        personas.add(new Persona("Ximena","Hernandez",49,null));
        personas.add(new Persona("Rogelio","Gutierrez",36,"Futbol"));

        return personas;
    }
}
