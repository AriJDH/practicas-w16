package com.example.ejerciciocalculadora.service;

import com.example.ejerciciocalculadora.dto.FoodDTO;
import com.example.ejerciciocalculadora.model.Food;
import com.example.ejerciciocalculadora.model.Plato;
import com.example.ejerciciocalculadora.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class Calculadora {
    @Autowired
   private FoodRepository listaFood=new FoodRepository();


    public String maximoIngrdiente(String plato){
        return listaFood.plato(plato).nombreDelMasAlto();
        }
    public int totalCalorias(String plato){
        return listaFood.plato(plato).sumaDeCalorias();

    }
    public List<FoodDTO> listaIngredientes(String plato){
       return listaFood.plato(plato).getIngredientes();
    }

    public List<FoodDTO> getFood(){
        return listaFood.getListaFood();
    }

    public Plato getPlato(String nombre){
        return listaFood.plato(nombre);
    }

    public List<String> listaTotalDeCalorias(List<String> plato){
        List<String> resul=new ArrayList<>();
        for(int i=0;i<plato.size();i++){
            int value=listaFood.plato(plato.get(i)).sumaDeCalorias();
            resul.add(String.valueOf(value).concat("value"));
        }
        return resul;
    }

    public List<String> listaMaximaCalorias(List<String> plato){
        List<String> resul=new ArrayList<>();
        for(int i=0;i<plato.size();i++){

            resul.add("value"+listaFood.plato(plato.get(i)).nombreDelMasAlto());
        }
        return resul;
    }

    public List<String> listaDeIngredientes(List<String> plato){
        List<String> resul=new ArrayList<>();
        for(int i=0;i<plato.size();i++){

            resul.add("value"+listaFood.plato(plato.get(i)).getIngredientes());
        }
        return resul;
    }

}
