package com.bootcamp.comida.repository;

import com.bootcamp.comida.entity.Ingrediente;
import com.bootcamp.comida.entity.Plato;

public class ComidaRepo {
    Repository<Ingrediente> IngredienteEntity = new Repository<Ingrediente>();
    Repository<Plato> PlatoEntity = new Repository<>();
    public ComidaRepo(){
        this.IngredienteEntity.loadDataBase();
    }
}
