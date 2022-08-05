package com.spring.calculadora_de_calorias.service;

import com.spring.calculadora_de_calorias.DTO.IngredienteDTO;
import com.spring.calculadora_de_calorias.entity.Ingrediente;
import com.spring.calculadora_de_calorias.entity.Plato;
import com.spring.calculadora_de_calorias.repository.PlatoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PlatoServiceImpl implements IPlatoService{

    @Autowired
    PlatoDAOImpl platoDAO;

    public Integer getCaloriasPlato(String name){

        List<Plato> listaPlatos = platoDAO.findAll();

        Plato plato = listaPlatos.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList()).stream().findFirst().get();

        Integer calTotal;

        calTotal = plato.getListaIngredientes().stream().reduce(0, (a,b) -> a + b.getCalories(), Integer::sum);

        return calTotal;
    }

    public List<IngredienteDTO> getIngredientesPlato(String name){
        List<IngredienteDTO> listaIng = platoDAO.findAll().stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList())
                .stream().findFirst().get()
                .getListaIngredientes().stream().map(i -> new IngredienteDTO(i.getName(), i.getCalories())).collect(Collectors.toList());
        return listaIng;
    }

    public IngredienteDTO mayorCalorias(String name){
        IngredienteDTO ingMayor = platoDAO.findAll().stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList())
                .stream().findFirst().get()
                .getListaIngredientes().stream()
                .map(i -> new IngredienteDTO(i.getName(), i.getCalories())).collect(Collectors.toList())
                .stream().min((a, b) -> b.getCalories().compareTo(a.getCalories())).get();

        return ingMayor;
    }

}
