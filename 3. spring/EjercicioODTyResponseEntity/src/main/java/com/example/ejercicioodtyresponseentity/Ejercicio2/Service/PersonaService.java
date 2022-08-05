package com.example.ejercicioodtyresponseentity.Ejercicio2.Service;

import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Deporte;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Persona;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonaService {
    int idPersona;
    private PersonaRepository personaRepository;
    public List<Persona> addPersona(String nombrePersona,String apellidoPersona, Integer edad) {
        return this.personaRepository.agregarPersona(nombrePersona,apellidoPersona,edad);
    }

}
