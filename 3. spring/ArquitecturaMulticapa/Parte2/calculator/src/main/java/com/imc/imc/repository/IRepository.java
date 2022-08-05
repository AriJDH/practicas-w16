package com.imc.imc.repository;

import com.imc.imc.entity.IngredienteEntity;

public interface IRepository {
    public IngredienteEntity findByName(String name);
}
