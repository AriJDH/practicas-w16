package com.example.calculadoracalorias.Service;

import com.example.calculadoracalorias.DTO.IngredienteDTO;
import com.example.calculadoracalorias.DTO.RequestDTO;
import com.example.calculadoracalorias.DTO.ResponseDTO;
import com.example.calculadoracalorias.Repository.RCalorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceIngrediente {
    @Autowired
    RCalorias platos;

    public ResponseDTO calcularDatos(RequestDTO comida) {
        ResponseDTO res = new ResponseDTO();
        int caloriasTotales = comida.getIngredientes().stream()
                .mapToInt(ingredientList -> {
                    int i = platos.loadIngredientes().stream()
                            .filter(ingredientes -> ingredientes.getName().equals(ingredientList))
                            .findFirst()
                            .get().getCalories();
                    return i * comida.getPeso();
                }).sum();

        res.setCaloriasTotales(caloriasTotales);

        List<IngredienteDTO> listIngredientes = comida.getIngredientes().stream()
                .map(ingrediente -> new IngredienteDTO(ingrediente, platos.loadIngredientes().stream()
                        .filter(ingredientes -> ingredientes.getName().equals(ingrediente))
                        .findFirst()
                        .get().getCalories()))
                .collect(Collectors.toList());

        res.setIngredientes(listIngredientes);

        IngredienteDTO ingrediente = listIngredientes.stream()
                .max(Comparator.comparing(IngredienteDTO::getCalories))
                .get();

        res.setIngredienteMayorCalorico(ingrediente);
        return res;
    }
}
