package com.bootcamp.ejerciciorestaurante.dto;

import com.bootcamp.ejerciciorestaurante.entities.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResponseDto {

    private int totalCalories;
    private List<IngredientsDto> ingredientsDto;
    private IngredientsDto mostCaloriesIngredient;


}
