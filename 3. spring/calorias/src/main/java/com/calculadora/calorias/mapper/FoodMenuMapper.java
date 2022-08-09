package com.calculadora.calorias.mapper;

import com.calculadora.calorias.dto.FoodMenuDTO;
import com.calculadora.calorias.entity.FoodMenu;
import com.calculadora.calorias.entity.Ingredient;

import java.util.Comparator;

public class FoodMenuMapper {

    public FoodMenuDTO ToDto(FoodMenu fm) {
        FoodMenuDTO foodMenuDTO = new FoodMenuDTO();
        foodMenuDTO.setName(fm.getName());
        foodMenuDTO.setIngredientList(fm.getIngredientList());
        foodMenuDTO.setTotalCalories(fm.getTotalCalories());
        foodMenuDTO.setHighestCalorieIngredient(fm.getIngredientList().stream()
                .max(Comparator.comparing(Ingredient::getCalories)).get());
        return foodMenuDTO;
    }

}
