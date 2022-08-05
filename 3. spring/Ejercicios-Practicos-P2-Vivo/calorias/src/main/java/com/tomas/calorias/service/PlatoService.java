package com.tomas.calorias.service;

import com.tomas.calorias.dto.PlatoDTO;
import com.tomas.calorias.dto.PlatoResponseDTO;
import com.tomas.calorias.dto.IngredienteDTO;

import java.util.List;


public interface PlatoService {

     PlatoResponseDTO getCalorias(PlatoDTO dish);

     List<PlatoResponseDTO> getTodasCalorias(List<PlatoDTO> dishes);

     IngredienteDTO getIngredientesCalorias();
}