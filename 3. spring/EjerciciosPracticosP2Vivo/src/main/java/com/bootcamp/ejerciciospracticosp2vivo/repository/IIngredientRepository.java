package com.bootcamp.ejerciciospracticosp2vivo.repository;

import com.bootcamp.ejerciciospracticosp2vivo.entity.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    List<Ingredient> getAll();
}
