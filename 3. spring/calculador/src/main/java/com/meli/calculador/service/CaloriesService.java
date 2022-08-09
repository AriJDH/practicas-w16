package com.meli.calculador.service;


import com.meli.calculador.dtos.IngredienteDto;
import com.meli.calculador.entity.Ingredientes;
import com.meli.calculador.entity.Plato;
import com.meli.calculador.repository.CaloriesRespository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaloriesService {


    public Plato getPlato(String name)
    {
        CaloriesRespository respository= new CaloriesRespository();

        return respository.getPlato().stream().filter(x-> x.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public double getCalories(String name)
    {
        return  this.getPlato(name).getIngredientes().stream().mapToDouble(x-> x.getCalories()).sum();
    }


    public List<IngredienteDto> getMostCalories(String name)
    {   Ingredientes ingrediente= this.getPlato(name).getIngredientes().stream().max(Comparator.comparingDouble(Ingredientes::getCalories)).get();
        List<Ingredientes> lista= this.getPlato(name).getIngredientes().stream().filter(x-> x.getCalories()==ingrediente.getCalories()).collect(Collectors.toList());
        return lista.stream().map(x-> new IngredienteDto(x.getName(), x.getCalories())).collect(Collectors.toList());
    }
}
