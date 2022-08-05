package com.CalculadoraCalorias.calorias.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientesDTO {


    private String name;
    private Integer calories;
}
