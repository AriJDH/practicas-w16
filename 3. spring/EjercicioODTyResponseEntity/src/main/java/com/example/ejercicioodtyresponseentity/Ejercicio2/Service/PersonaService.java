package com.example.ejercicioodtyresponseentity.Ejercicio2.Service;

import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Deporte;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Persona;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonaService {
    int idPersona;
    @Autowired
    private PersonaRepository personaRepository;
    public Persona addPersona(String nombrePersona,String apellidoPersona, Integer edad) {
        idPersona = idPersona+1;
        Persona persona = new Persona(idPersona,nombrePersona,apellidoPersona,edad);
        personaRepository.agregarPersona(persona);
        return persona;
    }
    public List<Persona> showPersons() {
        return this.personaRepository.showPersonsRepo();
    }

}
