package com.grodriguez.covid.services;

import com.grodriguez.covid.entities.Persona;
import com.grodriguez.covid.entities.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovidService {

    private List<Sintoma> sintomas;
    private List<Persona> personas;

    public CovidService() {

        this.sintomas = new ArrayList<>();
        this.sintomas.add(new Sintoma("cod01", "Tos", "bajo"));
        this.sintomas.add(new Sintoma("cod02", "Decaimiento", "medio"));
        this.sintomas.add(new Sintoma("cod01", "Fiebre", "alto"));

        this.personas = new ArrayList<>();
        this.personas.add(new Persona(1, "German", "Rodriguez", 30, this.sintomas.get(0)));
        this.personas.add(new Persona(1, "Romina", "Garcia", 28, this.sintomas.get(1)));
        this.personas.add(new Persona(1, "Patricia", "Alvarez", 75, this.sintomas.get(2)));
        this.personas.add(new Persona(1, "Rogelio", "Rodriguez", 97, this.sintomas.get(2)));
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public List<Persona> getPersonas(){
        return personas;
    }

    public String getSintoma(String nombre){

        String ret = "No existe el sintoma";
        Sintoma s = this.sintomas.stream()
                    .filter(x -> x.getNombre().equals(nombre))
                    .findFirst()
                    .orElse(null);

        if(s != null)
            ret = s.getNivel_de_gravedad();

        return ret;
    }
}
