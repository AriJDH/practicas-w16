package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.entity.Ingrediente;
import com.bootcamp.calculadoracalorias.entity.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class CalculadoraRepository {

  private List<Plato> platos;
  private List<Ingrediente> ingredientes;
  private ParseJson p = new ParseJson();

  public CalculadoraRepository() {
    this.ingredientes = p.cargarIngredientes();
    this.platos = cargarPlatos();
  }

  public List<Ingrediente> obtenerIngredientes() {
    return ingredientes;
  }

  public List<Plato> cargarPlatos() {
    List<Plato> platos = new ArrayList<>();

    platos.add(new Plato("Premium", 230.0, randomIngredientes()));
    platos.add(new Plato("Basic", 300.0, randomIngredientes()));
    platos.add(new Plato("Standard", 260.0, randomIngredientes()));

    return platos;
  }

  public List<Plato> obtenerPlatos() {
    return platos;
  }

  public List<Ingrediente> randomIngredientes() {
    List<Ingrediente> ingredientes = obtenerIngredientes();
    List<Ingrediente> ret = new ArrayList<>();
    Random aleatorio = new Random();
    ret.add(ingredientes.get(aleatorio.nextInt(ingredientes.size())));
    ret.add(ingredientes.get(aleatorio.nextInt(ingredientes.size())));
    ret.add(ingredientes.get(aleatorio.nextInt(ingredientes.size())));
    return ret;
  }
}
