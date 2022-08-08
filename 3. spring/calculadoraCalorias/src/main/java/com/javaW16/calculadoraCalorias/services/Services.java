package com.javaW16.calculadoraCalorias.services;

import java.util.List;
import java.util.stream.Collectors;

import com.javaW16.calculadoraCalorias.dto.IngredienteDTO;
import com.javaW16.calculadoraCalorias.dto.PlatoDTO;
import com.javaW16.calculadoraCalorias.dto.ResponseDTO;
import com.javaW16.calculadoraCalorias.entities.PlatoEntity;
import com.javaW16.calculadoraCalorias.repository.IngredientesRepository;
import com.javaW16.calculadoraCalorias.repository.PlatosRepository;
import com.javaW16.calculadoraCalorias.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Services {

   @Autowired
   IngredientesRepository ingredientesRepository;
   @Autowired
   Utils utils;
   @Autowired
   PlatosRepository platosRepository;

   public ResponseDTO createIngredientesListService(List<IngredienteDTO> ingredientesDTO) {
      ResponseDTO resopnseDTO = new ResponseDTO("CRUD create request", "The request create was successfully");
      ingredientesRepository.cargarListaIngredientes(utils.convertIngredienteDTO(ingredientesDTO));
      return resopnseDTO;
   }

   public List<IngredienteDTO> getAllIngredientes() {
      return utils.convertIngredienteEntity(ingredientesRepository.getIngredientes());
   }

   public void createPlatosListService(PlatoDTO platoDTO) {
      platosRepository.cargarListaPlatos(
            PlatoEntity.builder()
                  .name(platoDTO.getName())
                  .listaIngredientes(platoDTO.getListaIngredientes())
                  .build());
   }

   public List<PlatoDTO> getAllPlatos(){

      List<PlatoDTO> platosDTO = platosRepository.getPlatos().stream()
      .map(Utils::DTOfromPlatosEntity)
      .collect(Collectors.toList());

      return platosDTO;

   }
}
