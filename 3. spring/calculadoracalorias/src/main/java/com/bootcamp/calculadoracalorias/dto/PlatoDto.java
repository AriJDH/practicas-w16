package com.bootcamp.calculadoracalorias.dto;

import com.bootcamp.calculadoracalorias.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDto {
    private List<Ingrediente> ingredientes;
    private int calorias;
    private Ingrediente ingredienteMayorCalorias;
}
