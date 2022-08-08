package com.spring.calculadora_de_calorias.repository;

import com.spring.calculadora_de_calorias.entity.Plato;

import java.util.List;

public interface IPlatoDAO {
    List<Plato> findAll();
}
