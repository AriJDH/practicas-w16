package com.bootcamp.calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String name;
    private List<Ingredient> ingredients;
    private Double weight;

    public Double getTotalCalories(){
        return this.ingredients.stream()
                .mapToLong(Ingredient::getCalories)
                .sum() * weight / 100;
    }

    public Double getTotalCalories(Double weight){
        return this.ingredients.stream()
                .mapToLong(Ingredient::getCalories)
                .sum() * weight / 100;
    }

    public Ingredient getMaxCaloryIngridient(){
        return this.ingredients.stream()
                .max(Comparator.comparing(Ingredient::getCalories))
                .get();
    }
}
