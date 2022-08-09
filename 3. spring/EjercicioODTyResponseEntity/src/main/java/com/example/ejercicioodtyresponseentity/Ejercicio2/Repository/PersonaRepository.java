package com.example.ejercicioodtyresponseentity.Ejercicio2.Repository;

import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class PersonaRepository {
    ArrayList<Persona> personasDeporte = new ArrayList<>();

    public void agregarPersona(Persona persona) {
        personasDeporte.add(persona);

    }
    public ArrayList<Persona> showPersonsRepo() {return personasDeporte;}
}
