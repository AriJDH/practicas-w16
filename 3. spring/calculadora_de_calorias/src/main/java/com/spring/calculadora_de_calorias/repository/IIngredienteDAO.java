package com.spring.calculadora_de_calorias.repository;

import com.spring.calculadora_de_calorias.DTO.IngredienteDTO;
import com.spring.calculadora_de_calorias.entity.Ingrediente;

import java.util.List;

public interface IIngredienteDAO {
    List<Ingrediente> findAll();
}
