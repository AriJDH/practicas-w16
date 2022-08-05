package com.example.calculadoracalorias.repository;


import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.entity.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class CalculadoraRepository implements ICalculadoraRepository {

    private final List<Plato> platos;
    private final List<Ingrediente> ingredientes;

    public CalculadoraRepository() {
        ParseJson p = new ParseJson();
        this.ingredientes = p.cargarIngredientes();
        this.platos = cargarPlatos();
    }

    public List<Ingrediente> obtenerIngredientes() {
        return ingredientes;
    }

    private List<Plato> cargarPlatos() {
        List<Plato> platos = new ArrayList<>();

        platos.add(new Plato("Premium", 230.0, randomIngredientes()));
        platos.add(new Plato("Basic", 300.0, randomIngredientes()));
        platos.add(new Plato("Standard", 260.0, randomIngredientes()));

        return platos;
    }

    public List<Plato> obtenerPlatos(){
        return platos;
    }

    private List<Ingrediente> randomIngredientes() {
        List<Ingrediente> ingredientes = obtenerIngredientes();
        List<Ingrediente> ret = new ArrayList<>();
        Random aleatorio = new Random();
        ret.add(ingredientes.get(aleatorio.nextInt(ingredientes.size())));
        ret.add(ingredientes.get(aleatorio.nextInt(ingredientes.size())));
        ret.add(ingredientes.get(aleatorio.nextInt(ingredientes.size())));
        return ret;
    }
}
