package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.model.Plato;

public interface IRepositoryPlatos {

    public Plato getPlatoByName(String name);
}
