package com.imc.imc.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorResponseDTO {
    private int weight;
    private int calories;
    private IngredientDTO mostCaloricIngredient;
    private List<IngredientDTO> ingredients;
}
