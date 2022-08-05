package com.restaurante.calorias.service;

import com.restaurante.calorias.dto.DishDTO;
import com.restaurante.calorias.dto.DishResponseDTO;
import com.restaurante.calorias.dto.IngredientDTO;

import java.util.List;

public interface DishService {

    public DishResponseDTO getCalories(DishDTO dish);

    public List<DishResponseDTO> getAllCalories(List<DishDTO> dishes);

    public IngredientDTO getIngredientsCalories();
}
