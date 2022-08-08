package com.meli.calculador.repository;

import com.meli.calculador.entity.Ingredientes;
import com.meli.calculador.entity.Plato;

import java.util.List;

public interface ICaloriesRepository {

    public List<Ingredientes> getIngredientes();
    public List<Plato> getPlato();



}
