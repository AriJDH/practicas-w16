package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.model.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {
    Ingrediente buscarIngrediente(String name);
}
