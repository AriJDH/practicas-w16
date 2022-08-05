package com.example.covid19.repository;

import com.example.covid19.entity.Persona;
import com.example.covid19.entity.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CovidRepository {

    public List<Sintoma> obtenerSintomas() {
        List<Sintoma> sintomas = new ArrayList<>();
        sintomas.add(new Sintoma("34AB", "fiebre", 3));
        sintomas.add(new Sintoma("35AC", "tos", 1));
        sintomas.add(new Sintoma("36AD", "mocos", 2));
        sintomas.add(new Sintoma("37AD", "cansancio", 3));

        return sintomas;
    }

    public List<Persona> obtenerPersonas() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Javier", "Rodriguez", 45, obtenerSintomas()));
        personas.add(new Persona(2, "Gabriel", "Gomez", 69, obtenerSintomas()));
        personas.add(new Persona(3, "Juan", "Perez", 89, new ArrayList<>()));

        return personas;
    }

}
