package com.bootcamp.restaurant.dto;

import com.bootcamp.restaurant.entity.Ingredient;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealDto {

    private String name;
    private Integer totalCalories;
    private List<Ingredient> ingredients;
    private String ingredientHighestCalories;
}
