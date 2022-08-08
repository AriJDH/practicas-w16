package com.bootcamp.calorias.dto.response;

import com.bootcamp.calorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishDTO {
    private String name;
    private List<Ingredient> ingredients;
    private Ingredient maxCaloryIngredient;
    private Double totalCalories;
    private Double weight;
}
