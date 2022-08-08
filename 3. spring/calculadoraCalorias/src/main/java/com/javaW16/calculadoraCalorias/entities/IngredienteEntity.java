package com.javaW16.calculadoraCalorias.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class IngredienteEntity {
   String name;
   Integer calories;
}
