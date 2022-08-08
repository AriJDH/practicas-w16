package com.meli.calculador.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {

     private String name;
     private double peso;
     private List<Ingredientes> ingredientes;

}
