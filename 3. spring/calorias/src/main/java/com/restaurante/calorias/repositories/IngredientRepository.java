package com.restaurante.calorias.repositories;


import com.restaurante.calorias.dto.IngredientDTO;

public interface IngredientRepository {

    IngredientDTO findIngredientByName(String name);
    IngredientDTO findMostCaloric();
}
