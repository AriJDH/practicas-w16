package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.CaloriaDTO;
import com.example.calculadoracalorias.dto.IngredienteDTO;

import java.util.List;

public interface ICalculadoraService {

    public CaloriaDTO obtenerCalorias(String plato);

    public List<IngredienteDTO> obtenerIngredientesPlato(String plato);

    public IngredienteDTO obtenerIngredienteMasCalorico(String plato);
}
