package com.javaW16.calculadoraCalorias.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.javaW16.calculadoraCalorias.dto.IngredienteDTO;
import com.javaW16.calculadoraCalorias.dto.PlatoDTO;
import com.javaW16.calculadoraCalorias.entities.IngredienteEntity;
import com.javaW16.calculadoraCalorias.entities.PlatoEntity;

import org.springframework.stereotype.Component;

@Component
public class Utils {

   public List<IngredienteEntity> convertIngredienteDTO (List<IngredienteDTO> ingredienteDTO){

         return ingredienteDTO.stream().map(x -> IngredienteEntity.builder()
         .name(x.getName())
         .calories(x.getCalories())
         .build()).collect(Collectors.toList());

   }

   public List<IngredienteDTO> convertIngredienteEntity (List<IngredienteEntity> ingredienteEntity){
         return ingredienteEntity.stream().map(x -> IngredienteDTO.builder()
         .name(x.getName())
         .calories(x.getCalories())
         .build()).collect(Collectors.toList());
   }

   public static PlatoDTO DTOfromPlatosEntity (PlatoEntity plato){
      return new PlatoDTO(
         plato.getName(),
         plato.getListaIngredientes()
      );
   }
}
