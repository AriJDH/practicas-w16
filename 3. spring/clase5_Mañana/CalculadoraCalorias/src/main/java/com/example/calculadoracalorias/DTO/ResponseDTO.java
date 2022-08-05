package com.example.calculadoracalorias.DTO;

import com.example.calculadoracalorias.Entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private int caloriasTotales;
    private List<IngredienteDTO> ingredientes;
    private IngredienteDTO ingredienteMayorCalorico;

}
