package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.model.Ingrediente;
import com.bootcamp.calculadoracalorias.model.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Repository
public class PlatoRepository implements IPlatoRepository{
    private List<Plato> platoList;
    private IIngredienteRepository ingredientesRepository;

    public PlatoRepository(){
        ingredientesRepository = new IngredienteRepository();
        Map<Ingrediente, Integer> ingredientes1 = new HashMap<>();
        ingredientes1.put(ingredientesRepository.buscarIngrediente("Alcachofas"), 12);
        ingredientes1.put(ingredientesRepository.buscarIngrediente("Calabaza"), 20);
        ingredientes1.put(ingredientesRepository.buscarIngrediente("Apio"), 5);
        Plato plato1 = new Plato("Plato1", ingredientes1);

        Map<Ingrediente, Integer> ingredientes2 = new HashMap<>();
        ingredientes2.put(ingredientesRepository.buscarIngrediente("Berenjena"), 23);
        ingredientes2.put(ingredientesRepository.buscarIngrediente("Berros"), 42);
        ingredientes2.put(ingredientesRepository.buscarIngrediente("Cebolla"), 8);
        Plato plato2 = new Plato("Plato2", ingredientes2);

        Map<Ingrediente, Integer> ingredientes3 = new HashMap<>();
        ingredientes3.put(ingredientesRepository.buscarIngrediente("Espinaca"), 62);
        ingredientes3.put(ingredientesRepository.buscarIngrediente("Hinojo"), 10);
        ingredientes3.put(ingredientesRepository.buscarIngrediente("Lechuga"), 15);
        Plato plato3 = new Plato("Plato3", ingredientes3);


        this.platoList = new ArrayList<>(Arrays.asList(plato1, plato2, plato3));

    }

    public Plato buscarPlato(String name){
        try{
            return platoList.stream().filter(plato -> plato.getNombre().equalsIgnoreCase(name)).findFirst().get();
        } catch (Exception ex){
            return null;
        }
    }


}
