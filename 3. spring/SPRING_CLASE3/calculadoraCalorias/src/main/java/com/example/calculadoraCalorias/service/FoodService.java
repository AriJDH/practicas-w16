package com.example.calculadoraCalorias.service;


import com.example.calculadoraCalorias.dtos.PlatoDTO;
import com.example.calculadoraCalorias.dtos.RequestFoodDTO;
import com.example.calculadoraCalorias.entities.Ingrediente;
import com.example.calculadoraCalorias.entities.Plato;
import com.example.calculadoraCalorias.repositories.Calculadorarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {

    Calculadorarepository repo = new Calculadorarepository();


    public PlatoDTO findPlato(String nombreDelPlato, Integer gramos){

        Optional<Plato> plato = this.repo.getBaseDePlatos().stream().filter(x->x.getNombre().equalsIgnoreCase(nombreDelPlato)).findFirst();

        if (plato.isPresent()){
            float calorias;

            Integer totalCalorias = 0;

            List<Ingrediente> lista = plato.get().getListaIngredientes();

            String mayorCalorias="";

            Integer maximoCalorias=0;

            for (Ingrediente i : lista){
                totalCalorias += i.getCalories();
                if (i.getCalories()>maximoCalorias){
                    maximoCalorias=i.getCalories();
                    mayorCalorias=i.getName();
                }
            }
            calorias = (gramos*totalCalorias)/plato.get().getGramos();

            return new PlatoDTO(plato.get().getNombre(),calorias,plato.get().getListaIngredientes(),mayorCalorias);
        }else{
            return null;
        }

    }

    public List<PlatoDTO> findPlato(List<RequestFoodDTO> lista) {
    List<PlatoDTO> listaRetorno= new ArrayList<>();
        for (RequestFoodDTO r : lista){
            List<Plato> listaplato = this.repo.getBaseDePlatos().stream().filter(x->x.getNombre().equalsIgnoreCase(r.getPlato())).collect(Collectors.toList());
            listaplato.forEach(x-> listaRetorno.add(findPlato(x.getNombre(),x.getGramos())));

        }
        return listaRetorno;
    }

}


