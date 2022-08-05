package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.model.Plato;

public interface IPlatoRepository {
    Plato buscarPlato(String name);
}
