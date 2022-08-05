package com.CalculadoraCalorias.calorias.services;


import com.CalculadoraCalorias.calorias.DTO.IngredientesDTO;
import com.CalculadoraCalorias.calorias.DTO.PlatosDTO;
import com.CalculadoraCalorias.calorias.repositories.caloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class caloriasService {

    @Autowired
    caloriasRepository ingredientesRepository;



    List<IngredientesDTO> ingredientes = new ArrayList<>();
    List<PlatosDTO> Platos = new ArrayList<>();




    public caloriasService() {
        PlatosDTO plato1 = new PlatosDTO("Arroz con pollo",300, Arrays.asList("Ajos", "Apio", "Pimiento", "Pollo", "Arroz integral"));
        PlatosDTO plato2 = new PlatosDTO("Hamburguesa",200,  Arrays.asList("Hamburguesa","Lechuga","Tomates","Cebolla", "Huevo duro"));
        PlatosDTO plato3 = new PlatosDTO("Postre de tres leches",150,  Arrays.asList("Limón", "Leche descremada","Galletas saladas"));
        Platos.add(plato1);
        Platos.add(plato2);
        Platos.add(plato3);
    }

    public Integer calcularCalorias(String plato) {

        ingredientes = ingredientesRepository.loadDataBase();

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (IngredientesDTO ingrediente : ingredientes) {
            hashMap.put(ingrediente.getName(), ingrediente.getCalories());
        }

        Integer calorias = 0;

        PlatosDTO platos = Platos.stream()
                .filter(PlatosDTO -> PlatosDTO.getName().equals(plato))
                .collect(Collectors.toList())
                .get(0);

        for (String ingrediente: platos.getIngredientes()) {
            calorias += hashMap.get(ingrediente);
        }
        calorias = calorias * platos.getGram();

        return calorias;
    }
    public Map<String,Integer> consultarIngredientes(String plato){

        ingredientes = ingredientesRepository.loadDataBase();

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (IngredientesDTO ingrediente : ingredientes) {
            hashMap.put(ingrediente.getName(), ingrediente.getCalories());
        }

        Map<String,Integer> ingredientesCalorias = new HashMap<>();

        List<String> ingredientesLista = Platos.stream()
                .filter(PlatosDTO -> PlatosDTO.getName().equals(plato))
                .collect(Collectors.toList())
                .get(0).getIngredientes();

        for (String ingrediente: ingredientesLista) {
            ingredientesCalorias.put(ingrediente, hashMap.get(ingrediente));
        }
        return ingredientesCalorias;
    }

    public Map.Entry<String,Integer> consultarMayorCaloria(String plato){

        Integer maxCaloria = 0;
        Map<String,Integer> ingredientes = consultarIngredientes(plato);

        Map.Entry<String, Integer> maxEntry = null;
        Integer max = Collections.max(ingredientes.values());

        for(Map.Entry<String, Integer> entry : ingredientes.entrySet()) {
            Integer value = entry.getValue();
            if(null != value && max == value) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }





}
