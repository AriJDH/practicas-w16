package com.example.springcalculadoradecalorias.service;

import com.example.springcalculadoradecalorias.dto.IngredienteDTO;
import com.example.springcalculadoradecalorias.dto.PlatoDTO;
import com.example.springcalculadoradecalorias.dto.InformacionPlatoDTO;
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

    public InformacionPlatoDTO getInformacion(PlatoDTO platoDTO) {
        InformacionPlatoDTO informacionPlatoDTO = new InformacionPlatoDTO();

        // calorias totales
        int caloriasTotales = platoDTO.getIngredientes().stream()
                .mapToInt(ingredienteDelPlato -> ingredientes.getAll().stream()
                        .filter(ingrediente -> ingrediente.getName().equals(ingredienteDelPlato.getNombre()))
                        .findFirst()
                        .get().getCalories() * ingredienteDelPlato.getPeso())
                .sum();
        informacionPlatoDTO.setCaloriasTotales(caloriasTotales);

        // ingredientes
        List<IngredienteDTO> ingredientesDelPlato = platoDTO.getIngredientes().stream()
                .map(ingredienteDelPlato -> new IngredienteDTO(ingredienteDelPlato.getNombre(), ingredientes.getAll().stream()
                        .filter(ingredientes -> ingredientes.getName().equals(ingredienteDelPlato.getNombre()))
                        .findFirst()
                        .get().getCalories()))
                .collect(Collectors.toList());
        informacionPlatoDTO.setIngredientes(ingredientesDelPlato);

        // ingrediente con mayor contenido calorico
        IngredienteDTO ingredienteMayorCalorico = ingredientesDelPlato.stream()
                .max(Comparator.comparing(IngredienteDTO::getCalorias))
                .get();
        informacionPlatoDTO.setIngredienteMayorCalorico(ingredienteMayorCalorico);

        return informacionPlatoDTO;
    }

    public List<InformacionPlatoDTO> getInformacion(List<PlatoDTO> platoDTOList) {
        return platoDTOList.stream().map(platoDTO -> this.getInformacion(platoDTO)).collect(Collectors.toList());
    }
}
