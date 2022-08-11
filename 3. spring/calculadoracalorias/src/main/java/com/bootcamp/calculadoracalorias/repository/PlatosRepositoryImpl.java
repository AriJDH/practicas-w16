package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.model.Ingrediente;
import com.bootcamp.calculadoracalorias.model.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlatosRepositoryImpl implements IRepositoryPlatos{

    private final List<Plato> platos;
    private final List<Ingrediente> ingredientes;


    public PlatosRepositoryImpl() {
        this.ingredientes = loadDataBaseIngredientes();
        this.platos = loadDataBase();
    }

    private List<Plato> loadDataBase() {
        List<Plato> platos = new ArrayList<>();

        Plato plato1 = new Plato("Plato 1",ingredientes.stream().limit(3).collect(Collectors.toList()));
        Plato plato2 = new Plato( "Plato 2", ingredientes.stream().skip(3).limit(3).collect(Collectors.toList()));
        Plato plato3 = new Plato( "Plato 3", ingredientes.stream().skip(6).limit(6).collect(Collectors.toList()));
        platos.add(plato1);
        platos.add(plato2);
        platos.add(plato3);
        return platos;
    }

    private List<Ingrediente> loadDataBaseIngredientes() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public Plato getPlatoByName(String name) {
        return platos.stream().filter(plato -> plato.getNombre().equalsIgnoreCase(name)).findFirst().get();
    }
}
