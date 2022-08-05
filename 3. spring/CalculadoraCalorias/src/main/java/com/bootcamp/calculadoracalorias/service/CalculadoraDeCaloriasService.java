package com.bootcamp.calculadoracalorias.service;

import com.bootcamp.calculadoracalorias.dto.IngredienteDTO;
import com.bootcamp.calculadoracalorias.model.Ingrediente;
import com.bootcamp.calculadoracalorias.model.Plato;
import com.bootcamp.calculadoracalorias.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraDeCaloriasService {
    @Autowired
    PlatoRepository platoRepository;

    public List<IngredienteDTO> ingredientesDelPlato(String platoNombre, double peso){
        Plato platoBuscado = platoRepository.buscarPlato(platoNombre);
        List<IngredienteDTO> ingredienteDTOList = new ArrayList<>();
        platoBuscado.getIngredientes().entrySet().forEach(entry -> {
            IngredienteDTO ingredienteDTO = new IngredienteDTO(entry.getKey().getName(), calcularPesoIngrediente(platoBuscado, entry.getKey(), peso), calcularCaloriasIngrediente(platoBuscado, entry.getKey(), peso));
            ingredienteDTOList.add(ingredienteDTO);
        });
        return ingredienteDTOList;


    }

    public double cantidadCaloriasPlato(String platoNombre, double peso){
        return platoRepository.buscarPlato(platoNombre).obtenerCaloriasPorPeso(peso);
    }

    private double calcularCaloriasIngrediente(Plato plato, Ingrediente ingrediente, double cantidadPlato){
        return (cantidadPlato/plato.getPeso())*ingrediente.getCalories()*plato.getIngredientes().get(ingrediente)/100;
    }

    private double calcularPesoIngrediente(Plato plato, Ingrediente ingrediente, double cantidadPlato){
        return (cantidadPlato/plato.getPeso())*plato.getIngredientes().get(ingrediente);
    }

    public String ingredienteMayorCalorias(String platoNombre, double peso){
        Plato platoBuscado = platoRepository.buscarPlato(platoNombre);
        return platoBuscado.ingredienteMayorCalorias(peso);
    }


}
