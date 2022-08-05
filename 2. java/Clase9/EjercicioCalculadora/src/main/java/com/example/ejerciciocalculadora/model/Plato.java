package com.example.ejerciciocalculadora.model;

import com.example.ejerciciocalculadora.dto.FoodDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Plato {
    private String nombre;
    private int gramos;
    private List<FoodDTO> ingredientes;


    public int sumaDeCalorias(){
        return ingredientes.stream().mapToInt(value -> value.getCalories()).sum();
    }
    public String nombreDelMasAlto(){
        return ingredientes.stream().max(Comparator.comparingInt(FoodDTO-> FoodDTO.getCalories())).map(e-> e.getName()).get();
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", gramos=" + gramos +
                ", ingredientes=" + ingredientes +
                '}';
    }
    //return listaFood.getListaPlato().stream().filter(e->e.getNombre().equals(plato)).max(Comparator.comparing(food -> food.getIngredientes())).map(e-> e.getName()).get();

}
