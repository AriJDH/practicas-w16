package com.javaW16.calculadoraCalorias.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class PlatoDTO {
   String name;
   List<String> listaIngredientes;
}
