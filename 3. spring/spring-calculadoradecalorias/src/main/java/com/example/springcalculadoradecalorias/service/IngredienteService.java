package com.example.springcalculadoradecalorias.service;

import com.example.springcalculadoradecalorias.dto.IngredienteDTO;
import com.example.springcalculadoradecalorias.dto.RequestDTO;
import com.example.springcalculadoradecalorias.dto.ResponseDTO;
import com.example.springcalculadoradecalorias.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository ingredientes;

    public ResponseDTO calcularDatos(RequestDTO requestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        // calorias totales
        int caloriasTotales = requestDTO.getIngredientes().stream()
                .mapToInt(ingredienteDelPlato -> ingredientes.getAll().stream()
                        .filter(ingrediente -> ingrediente.getName().equals(ingredienteDelPlato.getNombre()))
                        .findFirst()
                        .get().getCalories() * ingredienteDelPlato.getPeso())
                .sum();
        responseDTO.setCaloriasTotales(caloriasTotales);

        // ingredientes
        List<IngredienteDTO> ingredientesDelPlato = requestDTO.getIngredientes().stream()
                .map(ingredienteDelPlato -> new IngredienteDTO(ingredienteDelPlato.getNombre(), ingredientes.getAll().stream()
                        .filter(ingredientes -> ingredientes.getName().equals(ingredienteDelPlato.getNombre()))
                        .findFirst()
                        .get().getCalories()))
                .collect(Collectors.toList());
        responseDTO.setIngredientes(ingredientesDelPlato);

        // ingrediente con mayor contenido calorico
        IngredienteDTO ingredienteMayorCalorico = ingredientesDelPlato.stream()
                .max(Comparator.comparing(IngredienteDTO::getCalorias))
                .get();
        responseDTO.setIngredienteMayorCalorico(ingredienteMayorCalorico);

        return responseDTO;
    }
}
