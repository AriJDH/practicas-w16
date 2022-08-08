package com.bootcamp.CalculadoraCalorias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    private String name;
    private int peso;
    private List<Ingrediente> detalleDeIngredientes;
    private int totalDeCalorias;
    private String masCalorico;
}
