package com.meli.calculador.dtos;

import com.meli.calculador.entity.Ingredientes;
import com.meli.calculador.entity.Plato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDto {

    private String name;
    private double peso;
    private List<Ingredientes> ingredientes;



}
