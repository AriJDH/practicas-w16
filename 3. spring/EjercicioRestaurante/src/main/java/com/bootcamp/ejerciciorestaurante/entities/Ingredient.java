package com.bootcamp.ejerciciorestaurante.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Ingredient {

    private String name;
    private int calories;

}
