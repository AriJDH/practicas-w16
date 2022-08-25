package com.example.deportista.repository;

import com.example.deportista.entity.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRespository implements Repository<Deporte>{

    private List<Deporte> deportes= new ArrayList<>();

    @Override
    public List<Deporte> getAll() {
        deportes.add(new Deporte("Futbol","Medio"));
        deportes.add(new Deporte("Karate","Alto"));
        deportes.add(new Deporte("Basketball","Medio"));
        deportes.add(new Deporte("Voliboll","Facil"));
        deportes.add(new Deporte("Tennis","Facil"));
        return deportes;
    }

    public Deporte getDeporte(String name){
        return deportes.stream().filter(deporte -> deporte.getNombre().equalsIgnoreCase(name))
                .findFirst().get();
    }
}
