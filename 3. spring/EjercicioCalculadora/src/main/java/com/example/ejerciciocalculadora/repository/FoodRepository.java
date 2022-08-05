package com.example.ejerciciocalculadora.repository;

import com.example.ejerciciocalculadora.dto.FoodDTO;
import com.example.ejerciciocalculadora.model.Food;
import com.example.ejerciciocalculadora.model.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Repository
@Getter
@Setter

public class FoodRepository {
        private List<FoodDTO> listaFood=new ArrayList<>();
        private List<Plato> listaPlato=new ArrayList<>();


    public FoodRepository() {
        this.listaFood = loadFood();
        loadPlato();
    }

    public Plato plato(String plato){
       return  listaPlato.stream().filter(e-> e.getNombre().equals(plato)).findFirst().get();
    }
    private void loadPlato(){
        List<FoodDTO> ingredientes=new ArrayList<>();
        ingredientes.add(listaFood.get(1));
        ingredientes.add(listaFood.get(2));
        ingredientes.add(listaFood.get(3));
        List<FoodDTO> ingredientes1=new ArrayList<>();
        ingredientes1.add(listaFood.get(4));
        ingredientes1.add(listaFood.get(5));
        ingredientes1.add(listaFood.get(6));
        ingredientes1.add(listaFood.get(7));
        listaPlato.add(new Plato("plato1",200,ingredientes));
        listaPlato.add(new Plato("plato2",300,ingredientes1));

    }

    private List<FoodDTO> loadFood(){
        File file = null;
        System.out.println("estoy aca");
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<FoodDTO>> typeRef = new TypeReference<>() {};
        List<FoodDTO> food = null;
        try {
            System.out.println("estoy aca");
            food = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("me rompi");
        }


        return food;
    }

}
