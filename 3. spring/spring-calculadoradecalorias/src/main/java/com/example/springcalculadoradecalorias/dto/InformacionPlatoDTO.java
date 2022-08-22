package com.example.springcalculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformacionPlatoDTO {
    private int caloriasTotales;
    private List<IngredienteDTO> ingredientes;
    private IngredienteDTO ingredienteMayorCalorico;
}
