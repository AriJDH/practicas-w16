package com.bootcamp.calorias.utils;

import com.bootcamp.calorias.dto.response.DishDTO;
import com.bootcamp.calorias.entity.Dish;

public class Util {
    public static DishDTO parseDishToDishDTO(Dish dish){
        DishDTO dishDTO = new DishDTO();
        dishDTO.setIngredients(dish.getIngredients());
        dishDTO.setName(dish.getName());
        dishDTO.setMaxCaloryIngredient(dish.getMaxCaloryIngridient());
        dishDTO.setWeight(dish.getWeight());
        dishDTO.setTotalCalories(dish.getTotalCalories());
        return dishDTO;
    }

    public static DishDTO parseDishToDishWithWeightDTO(Dish dish, Double weight){
        DishDTO dishDTO = new DishDTO();
        dishDTO.setIngredients(dish.getIngredients());
        dishDTO.setName(dish.getName());
        dishDTO.setMaxCaloryIngredient(dish.getMaxCaloryIngridient());
        dishDTO.setWeight(weight);
        dishDTO.setTotalCalories(dish.getTotalCalories(weight));
        return dishDTO;
    }
}
