package com.example.calculadoracalorias.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteRequestDTO {
    private String nombre;
    private int peso;
}
