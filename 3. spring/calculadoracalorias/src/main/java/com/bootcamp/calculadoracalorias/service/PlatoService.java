package com.bootcamp.calculadoracalorias.service;

import com.bootcamp.calculadoracalorias.dto.PlatoDto;
import com.bootcamp.calculadoracalorias.dto.RequestPlatoDto;
import com.bootcamp.calculadoracalorias.model.Ingrediente;
import com.bootcamp.calculadoracalorias.model.Plato;
import com.bootcamp.calculadoracalorias.repository.IRepositoryPlatos;
import com.bootcamp.calculadoracalorias.repository.PlatosRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoService {


    private final IRepositoryPlatos platosRepository;

    public PlatoService(PlatosRepositoryImpl platosRepository) {
//        this.platosRepository = new PlatosRepositoryImpl();
        this.platosRepository = platosRepository;
    }

    public PlatoDto getInfoPlato(String nombre, int peso) {
        Plato plato = platosRepository.getPlatoByName(nombre);
        Ingrediente ingredienteMayorCaloria = plato.getElementoMaxCaloria();
        int caloriasTotales = plato.getTotalCalorias();

        return new PlatoDto(plato.getIngredientes(),caloriasTotales,ingredienteMayorCaloria);
    }


    public List<PlatoDto> getInfoListaPlatos (List<RequestPlatoDto> platos){
        List<PlatoDto> platoDtoList = new ArrayList<>();

        platos.forEach(requestPlatoDto -> platoDtoList.add(getInfoPlato(requestPlatoDto.getNombre(),requestPlatoDto.getPeso())));

        return platoDtoList;
    }
}
