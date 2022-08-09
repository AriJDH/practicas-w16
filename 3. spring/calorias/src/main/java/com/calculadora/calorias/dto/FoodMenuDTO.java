package com.calculadora.calorias.dto;

import com.calculadora.calorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenuDTO {

    private String name;
    private List<Ingredient> ingredientList;
    private double totalCalories;
    private Ingredient highestCalorieIngredient;
    private double caloriesByWeight;
}
