package com.example.covid19.Repository;

import com.example.covid19.Entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class RepositoryPersona {
    private static List<Persona> personas = new ArrayList<>();

    public static List<Persona> allPersonas(){
        Persona persona1 = new Persona(1,"Persona 1","Apellido 1",65,new ArrayList<>());
        Persona persona2 = new Persona(2,"Persona 2","Apellido 2",40,new ArrayList<>());
        Persona persona3 = new Persona(3,"Persona 3","Apellido 3",70,new ArrayList<>());
        persona1.getSintomas().add(RepositorySintoma.allSintomas().get(0));
        persona3.getSintomas().add(RepositorySintoma.allSintomas().get(1));
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        return personas;
    }
}
