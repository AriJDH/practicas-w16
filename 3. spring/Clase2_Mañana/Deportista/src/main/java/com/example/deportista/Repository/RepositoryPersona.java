package com.example.deportista.Repository;

import com.example.deportista.Entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class RepositoryPersona {
    private static List<Persona> personas = new ArrayList<>();

    public static List<Persona> allPersonas() {
        Persona p = new Persona("Nombre 1", "Apellido 1", 15,RepositoryDeporte.allDeportes().get(0));
        Persona p2 = new Persona("Nombre 2", "Apellido 2", 15,RepositoryDeporte.allDeportes().get(1));
        personas.add(p);
        personas.add(p2);
        return personas;
    }
}
