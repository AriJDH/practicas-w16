package com.personajes.starwars.repository;

import com.personajes.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository {

    private List<Personaje> personajes = new ArrayList<>();

    @Override
    public void saveAll(List<Personaje> personajesAGuardar) {
        this.personajes.addAll(personajesAGuardar);
    }

    @Override
    public List<Personaje> findAll() {
        return this.personajes;
    }

    @Override
    public List<Personaje> findAllByName(String name) {
        return this.personajes;
    }
}
