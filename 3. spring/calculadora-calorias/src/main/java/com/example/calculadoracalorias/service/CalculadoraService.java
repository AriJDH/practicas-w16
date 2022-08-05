package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.CaloriaDTO;
import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.entity.Plato;
import com.example.calculadoracalorias.repository.CalculadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculadoraService implements ICalculadoraService {

    private final CalculadoraRepository repository;

    @Autowired
    public CalculadoraService(CalculadoraRepository repository) {
        this.repository = repository;
    }

    public CaloriaDTO obtenerCalorias(String plato){
        List<Plato> platos = repository.obtenerPlatos();
        Plato p = platos.stream()
                .filter(plato1 -> plato1.getNombre().equals(plato))
                .findFirst()
                .orElse(null);
        if(p == null){
            return new CaloriaDTO(0);
        }
        System.out.println(p.getIngredientes());
        return new CaloriaDTO(p.getIngredientes().stream().mapToInt(Ingrediente::getCalorias).sum()) ;
    }


    public List<IngredienteDTO> obtenerIngredientesPlato(String plato) {
        List<Plato> platos = repository.obtenerPlatos();
        Plato p = platos.stream()
                .filter(plato1 -> plato1.getNombre().equals(plato))
                .findFirst()
                .orElse(null);
        if( p == null){
            return new ArrayList<>();
        }
        return p.getIngredientes().stream()
                .map(ingrediente -> new IngredienteDTO(ingrediente.getNombre(), ingrediente.getCalorias()))
                .collect(Collectors.toList());
    }

    public IngredienteDTO obtenerIngredienteMasCalorico(String plato){
        List<Plato> platos = repository.obtenerPlatos();
        Plato p = platos.stream()
                .filter(plato1 -> plato1.getNombre().equals(plato))
                .findFirst()
                .orElse(null);
        if( p == null){
            return null;
        }
        Ingrediente i = p.getIngredientes().stream().max(Comparator.comparing(Ingrediente::getCalorias)).orElse(null);
        System.out.println(p.getIngredientes());
        return i != null ? new IngredienteDTO(i.getNombre(), i.getCalorias()) : null;
    }
}
