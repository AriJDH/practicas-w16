package com.tomas.calorias.service;

import com.tomas.calorias.dto.PlatoResponseDTO;
import com.tomas.calorias.dto.IngredienteDTO;
import com.tomas.calorias.dto.PlatoDTO;
import com.tomas.calorias.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoServiceImplementacion implements PlatoService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public PlatoServiceImplementacion(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public PlatoResponseDTO getCalorias(PlatoDTO dish) {

        Integer calories = dish.getIngredients().stream().map(d->d.getCalories()).reduce(0,Integer::sum);
        PlatoResponseDTO dishResponseDTO = new PlatoResponseDTO(dish);
        dishResponseDTO.setCalories(calories);

        return dishResponseDTO;
    }

    @Override
    public List<PlatoResponseDTO> getTodasCalorias(List<PlatoDTO> dishes) {
        List<PlatoResponseDTO> listDishes = new ArrayList<>();

        for(PlatoDTO platoDTO : dishes){
            listDishes.add(getCalorias(platoDTO));
        }

        return listDishes.stream().sorted(Comparator.comparingInt(PlatoResponseDTO::getCalories).reversed()).collect(Collectors.toList());
    }

    @Override
    public IngredienteDTO getIngredientesCalorias() {

        return ingredienteRepository.encontrarMayorCaloria();

    }
}
