package com.example.calculadoraCalorias.repositories;

import com.example.calculadoraCalorias.dtos.PlatoDTO;
import com.example.calculadoraCalorias.entities.Ingrediente;
import com.example.calculadoraCalorias.entities.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Data
public class Calculadorarepository {

    List<Ingrediente> baseDeIngredientes;
    List<Plato> baseDePlatos;


    public Calculadorarepository() {
        this.baseDePlatos = new ArrayList<>();
        this.baseDeIngredientes = loadDataBase();
        llenadoDePlatos();

    }

    private Ingrediente encontrarIngrediente(String nombre){

        Optional<Ingrediente> ingredientes = this.baseDeIngredientes.stream().filter(x->x.getName().equalsIgnoreCase(nombre)).collect(Collectors.toList()).stream().findFirst();
        return ingredientes.orElse(null);
    }

    private void llenadoDePlatos(){

        Ingrediente ing;

        List<Ingrediente> listaMilanesa = new ArrayList<>();

        ing = encontrarIngrediente("Papas Cocidas");
        if (ing!=null)
            listaMilanesa.add(ing);

        ing = encontrarIngrediente("Ternera");
        if (ing!=null)
            listaMilanesa.add(ing);

        Plato plato1 = new Plato(listaMilanesa, "milanesa con pure", 600);

        List<Ingrediente> listaSopa = new ArrayList<>();

        ing = encontrarIngrediente("Papas Cocidas");
        if (ing!=null)
            listaSopa.add(ing);

        ing = encontrarIngrediente("Pollo");
        if (ing!=null)
            listaSopa.add(ing);

        ing = encontrarIngrediente("Acelgas");
        if (ing!=null)
            listaSopa.add(ing);

        Plato plato2 = new Plato(listaSopa, "sopa", 500);

        baseDePlatos.add(plato1);
        baseDePlatos.add(plato2);

    }

    private List<Ingrediente> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> obj = null;
        try {
            obj = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
