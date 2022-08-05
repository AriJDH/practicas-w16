package com.ndemaio.ejerciciocalculadoradecalorias.dto;

import com.ndemaio.ejerciciocalculadoradecalorias.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MealDTO {

    private final Integer totalCaloriesAmount;
    private final List<Food> ingredients;
    private final Food ingredientWithMaxCalories;

}
