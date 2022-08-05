package com.ndemaio.ejerciciocalculadoradecalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Getter
public class Meal {

    public final String name;
    public final List<Food> ingredients;

    public Integer totalCalories() {
        return ingredients.stream().mapToInt(Food::getCalories).sum();
    }

    public Food maxCaloriesIngredient() {
        return ingredients.stream().max(Comparator.comparingInt(Food::getCalories)).get();
    }
}
