package com.grodriguez.deportistas.service;

import com.grodriguez.deportistas.entities.Deporte;
import com.grodriguez.deportistas.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteService {

    public List<Deporte> deportes;
    public List<Persona> personas;

    public DeporteService() {
        this.deportes = new ArrayList<>();
        this.deportes.add(new Deporte("Futbol", "Alto"));
        this.deportes.add(new Deporte("Basket", "Medio"));
        this.deportes.add(new Deporte("Tenis", "Bajo"));

        this.personas = new ArrayList<>();
        this.personas.add(new Persona("Juan", "Perez", 30, this.deportes.get(0)));
        this.personas.add(new Persona("Pedro", "Lopez", 30, this.deportes.get(1)));
        this.personas.add(new Persona("Pepito", "Gonzalez", 30, this.deportes.get(2)));
    }

    public String getLevel(String name){
        String ret = "No existe el deporte";

        Deporte deporte = this.deportes.stream().filter(x -> x.getNombre().equals(name)).findFirst().orElse(null);

        if(deporte != null)
            ret = deporte.getNivel();

        return ret;
    }

    public List<Deporte> getAllSports(){
        return this.deportes;
    }

    public List<Persona> getAllPersonas(){
        return this.personas;
    }
}
