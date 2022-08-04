package com.starwars.starwars.repository;

import java.util.List;

import com.starwars.starwars.entity.Personaje;

public interface IRepository {
    public List<Personaje> findAllByNameContains(String name);
}
