package com.bootcamp.calculadoracalorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Ingrediente {
    private String name;
    private int calories;


}
