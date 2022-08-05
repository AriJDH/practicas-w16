package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.entity.Plato;

import java.util.List;

public interface ICalculadoraRepository {

    public List<Ingrediente> obtenerIngredientes();

    public List<Plato> obtenerPlatos();
}
