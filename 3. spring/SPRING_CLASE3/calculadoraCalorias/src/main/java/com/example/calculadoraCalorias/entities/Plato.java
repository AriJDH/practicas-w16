package com.example.calculadoraCalorias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {

    private List<Ingrediente> listaIngredientes;
    private String nombre;
    private Integer gramos;
}
