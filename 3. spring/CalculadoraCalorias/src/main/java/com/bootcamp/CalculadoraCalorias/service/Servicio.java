package com.bootcamp.CalculadoraCalorias.service;

import com.bootcamp.CalculadoraCalorias.dto.IngredienteDTO;
import com.bootcamp.CalculadoraCalorias.dto.PlatoDTO;
import com.bootcamp.CalculadoraCalorias.entities.Plato;
import com.bootcamp.CalculadoraCalorias.repository.IngredientesRepo;
import com.bootcamp.CalculadoraCalorias.repository.PlatosRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servicio {
    private final PlatosRepo platoRepo;

    public Servicio(PlatosRepo platoRepo) {
        this.platoRepo = platoRepo;
    }

    public PlatoDTO getPlatoDTO(String name) {
        return platoRepo.MostrarPlato(name);
    }

    public List<PlatoDTO> getListaPlatosDTO(String platillo1, String platillo2, String platillo3){
        return platoRepo.listarPlatos(platillo1, platillo2, platillo3);
    }
}
