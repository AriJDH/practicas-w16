package com.spring.calculadora_de_calorias.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {

    private String name;
    private List<IngredienteDTO> listaIngredientes;

}
