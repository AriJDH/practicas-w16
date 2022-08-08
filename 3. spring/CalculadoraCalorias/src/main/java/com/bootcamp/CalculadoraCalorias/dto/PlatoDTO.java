package com.bootcamp.CalculadoraCalorias.dto;

import com.bootcamp.CalculadoraCalorias.entities.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private String name;
    private int peso;
    private List<Ingrediente> detalleDeIngredientes;
    private int totalDeCalorias;
    private String masCalorico;
}
