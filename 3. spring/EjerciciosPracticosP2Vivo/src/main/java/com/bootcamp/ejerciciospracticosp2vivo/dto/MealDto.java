package com.bootcamp.ejerciciospracticosp2vivo.dto;

import com.bootcamp.ejerciciospracticosp2vivo.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MealDto {
    private String name;
    private Double totaCalories;
    private List<Ingredient> ingredients;
    private String ingredientHighestCalories;
}
