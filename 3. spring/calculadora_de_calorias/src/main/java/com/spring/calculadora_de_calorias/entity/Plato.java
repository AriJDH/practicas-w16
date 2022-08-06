package com.spring.calculadora_de_calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plato {

    private String name;
    private List<Ingrediente> listaIngredientes;

}
