package com.deportistas.repositories;

import java.util.ArrayList;
import java.util.List;

import com.deportistas.dto.Deporte;

public class SportRepository implements Repository<Deporte> {
    private List<Deporte> sports;
    
    public SportRepository() {
        sports = new ArrayList<Deporte>();
        sports.add(new Deporte("Futbol", 2));
        sports.add(new Deporte("Baloncesto", 3));
        sports.add(new Deporte("Tenis", 2));
        sports.add(new Deporte("Natacion", 2));
        sports.add(new Deporte("Bicicleta", 4));
        sports.add(new Deporte("Gimnasia", 5));
        sports.add(new Deporte("Patinaje", 2));
        sports.add(new Deporte("Otro", 2));
    }
    
    @Override
    public List<Deporte> findAll() {
        return sports;
    }
    
    @Override
    public void save(Deporte entity) {
        sports.add(entity);
    }
    
    @Override
    public void delete(Deporte entity) {
        sports.remove(entity);
    }

    public Deporte findByName(String name) {
        
        return sports.stream().filter( sport -> {
            return sport.getNombre().equals(name);
        })
        .findFirst()
        .orElse(null);
    }
    
}
