package com.example.ejercicioodtyresponseentity.Ejercicio2.Repository;

import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Persona;

import java.util.ArrayList;

public class PersonaRepository {
    int idpersona;
    ArrayList<Persona> personas = new ArrayList<>();

    int idPersona;

    public ArrayList<Persona> agregarPersona(String nombrePersona, String apellidoPersona, Integer edadPersona) {
        idPersona += 1;
        Persona persona = new Persona(idPersona, nombrePersona, apellidoPersona, edadPersona);
        personas.add(persona);
        return personas;
    }
}
