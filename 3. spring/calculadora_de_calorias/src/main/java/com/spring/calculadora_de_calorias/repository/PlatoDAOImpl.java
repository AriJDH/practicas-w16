package com.spring.calculadora_de_calorias.repository;

import com.spring.calculadora_de_calorias.entity.Ingrediente;
import com.spring.calculadora_de_calorias.entity.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoDAOImpl implements IPlatoDAO{

    @Autowired
    IngredienteDAOImpl ingredienteDAO;

    @Override
    public List<Plato> findAll() {

        List<Ingrediente> listaIng = ingredienteDAO.findAll();
        List<Ingrediente> ingredientes = new ArrayList<>();
        ingredientes.add(listaIng.get(3));
        ingredientes.add(listaIng.get(5));
        ingredientes.add(listaIng.get(14));

        List<Ingrediente> ingredientes2 = new ArrayList<>();
        ingredientes2.add(listaIng.get(0));
        ingredientes2.add(listaIng.get(1));
        ingredientes2.add(listaIng.get(2));

        List<Ingrediente> ingredientes3 = new ArrayList<>();
        ingredientes3.add(listaIng.get(6));
        ingredientes3.add(listaIng.get(2));
        ingredientes3.add(listaIng.get(9));

        List<Plato> lista = new ArrayList<>();
        Plato pl1 = new Plato("Plato 1", ingredientes);
        Plato pl2 = new Plato("Plato 2", ingredientes2);
        Plato pl3 = new Plato("Plato 3", ingredientes3);

        lista.add(pl1);
        lista.add(pl2);
        lista.add(pl3);

        return lista;
    }

}
