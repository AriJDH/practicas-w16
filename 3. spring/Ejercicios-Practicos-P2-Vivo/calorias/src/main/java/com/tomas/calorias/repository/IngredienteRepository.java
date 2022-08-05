package com.tomas.calorias.repository;

import com.tomas.calorias.dto.IngredienteDTO;

public interface IngredienteRepository {

    IngredienteDTO encontrarIngrediente(String name);
    IngredienteDTO encontrarMayorCaloria();
}