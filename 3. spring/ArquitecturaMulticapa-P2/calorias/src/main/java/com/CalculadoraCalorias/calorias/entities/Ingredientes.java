package com.CalculadoraCalorias.calorias.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ingredientes {

    private String name;
    private Integer calories;
}
