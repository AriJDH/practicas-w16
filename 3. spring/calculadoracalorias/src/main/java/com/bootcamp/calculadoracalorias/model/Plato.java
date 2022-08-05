package com.bootcamp.calculadoracalorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;

    public Ingrediente getElementoMaxCaloria() {
        return ingredientes.stream().max(Comparator.comparing(Ingrediente::getCalories)).get();
    }

    public int getTotalCalorias(){
        return ingredientes.stream().mapToInt(Ingrediente::getCalories).sum();
    }
}
