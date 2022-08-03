package com.grupodeportista.personasdeportes.report;

import com.grupodeportista.personasdeportes.entities.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepo {

    private static List<Persona> personas= new ArrayList<>();


    public static List<Persona> getAllPersona(){


        personas.add(new Persona("Andres","Roa",22, DeporteRepo.findSport("futbol")));
        personas.add(new Persona("Gabriela", "Mejia", 22, DeporteRepo.findSport("Baloncesto")));

        return personas;
    }


}
