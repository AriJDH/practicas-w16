package com.calculadora.calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenu {

    private String name;
    private List<Ingredient> ingredientList;
    private double totalCalories;

    public FoodMenu(String name, List<Ingredient> ingredientList ){
        this.name = name;
        this.ingredientList = ingredientList;
        this.totalCalories = getTotalCalories();
    }
    public double getTotalCalories(){
        return  this.ingredientList.stream()
                .mapToDouble(Ingredient::getCalories).sum();
    }

    public Double getTotalCaloriesByWeight(Double weight){
        return getTotalCalories() * weight;
    }

}
