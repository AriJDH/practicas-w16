package com.bootcamp.ejerciciospracticosp2vivo.repository;

import com.bootcamp.ejerciciospracticosp2vivo.entity.Meal;

import java.util.List;

public interface IMealRepository {
    List<Meal> getAllMeal();
    Meal getByNameWeight(String name, Double weight);

}
