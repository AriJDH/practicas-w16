package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    void initializeRepo();
    List<Personaje> getAll();
    List<Personaje> getByName(String name);
}
