package com.javaW16.calculadoraCalorias.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class IngredienteDTO {
   String name;
   Integer calories;
}
