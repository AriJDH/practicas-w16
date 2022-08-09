package com.personajes.starwars.repository;

import com.personajes.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StarWarsRepository {
    void saveAll(List<Personaje> personajesAGuardar);

    List<Personaje> findAll();

    List<Personaje> findAllByName(String name);
}
