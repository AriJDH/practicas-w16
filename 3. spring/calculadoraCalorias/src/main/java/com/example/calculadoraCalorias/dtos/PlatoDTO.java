package com.example.calculadoraCalorias.dtos;


import com.example.calculadoraCalorias.entities.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {

    private String name;
    private Float calories;
    private List<Ingrediente> listaDeIngredientes;
    private String nombreIngredienteCalorico;

}
