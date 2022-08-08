package com.javaW16.calculadoraCalorias.entities;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class PlatoEntity {
   String name;
   List<String> listaIngredientes;
}
