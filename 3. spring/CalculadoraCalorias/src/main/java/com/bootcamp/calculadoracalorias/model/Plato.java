package com.bootcamp.calculadoracalorias.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter @Getter
@NoArgsConstructor
public class Plato {
    private String nombre;
    private Map<Ingrediente, Integer> ingredientes;
    private double peso;
    private double calorias;

    public Plato(String nombre, Map<Ingrediente, Integer> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;

        this.peso = ingredientes.values().stream().mapToInt(x->x).sum();
        this.calorias = 0;

        ingredientes.forEach((ingrediente, peso) -> {
            this.calorias += ingrediente.getCalories()*peso/100;
        });
    }

    public double obtenerCaloriasPorPeso(double pesoDeseado){
        return this.calorias*pesoDeseado/this.peso;
    }

    public String ingredienteMayorCalorias(double pesoDeseado){
        Ingrediente ingredienteMaximo = this.ingredientes.keySet().stream().findFirst().get();
        double cantidadCaloriasMaxima = 0;

        for (var ingrediente:ingredientes.entrySet()) {
            double caloriasActual = ingrediente.getKey().getCalories()*ingrediente.getValue()/100;
            if(caloriasActual > cantidadCaloriasMaxima){
                ingredienteMaximo = ingrediente.getKey();
                cantidadCaloriasMaxima = caloriasActual;
            }
        }

        return ingredienteMaximo.getName();
    }


}
