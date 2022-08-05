package com.bootcamp.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class IngredienteDTO {
    private String name;
    private double peso;
    private double calorias;
}
