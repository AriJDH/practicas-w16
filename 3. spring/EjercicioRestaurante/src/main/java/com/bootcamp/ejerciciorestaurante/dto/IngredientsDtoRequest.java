package com.bootcamp.ejerciciorestaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsDtoRequest {
    private String name;
    private int grams;

}
