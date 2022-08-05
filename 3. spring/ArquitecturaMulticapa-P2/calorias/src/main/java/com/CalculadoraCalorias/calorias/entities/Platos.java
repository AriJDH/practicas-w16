package com.CalculadoraCalorias.calorias.entities;


import com.CalculadoraCalorias.calorias.repositories.caloriasRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Platos {

    private String name;
    private Integer gram;
    private List<String> ingredientes;

    @Autowired
    caloriasRepository ingredientesRepository;


    public void calcularIngredientes(){

    }
}
