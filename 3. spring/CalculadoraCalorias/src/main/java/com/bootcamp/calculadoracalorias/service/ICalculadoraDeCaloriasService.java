package com.bootcamp.calculadoracalorias.service;

import com.bootcamp.calculadoracalorias.dto.DatosPlatoDto;
import com.bootcamp.calculadoracalorias.dto.IngredienteDTO;

import java.util.List;

public interface ICalculadoraDeCaloriasService {
    public List<IngredienteDTO> ingredientesDelPlato(String platoNombre, double peso);
    public double cantidadCaloriasPlato(String platoNombre, double peso);
    public String ingredienteMayorCalorias(String platoNombre, double peso);

    public List<Double> cantidadCaloriasListaDePLatos(List<DatosPlatoDto> datosPlato);
    public List<List<IngredienteDTO>> ingredientesDeListaDePlatos(List<DatosPlatoDto> listaPlatos);
    public List<String> ingredienteMayorCaloriasListaPlatos(List<DatosPlatoDto> listaPlatos);
}
