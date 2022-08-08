package com.javaW16.calculadoraCalorias.repository;

import java.util.ArrayList;
import java.util.List;

import com.javaW16.calculadoraCalorias.entities.IngredienteEntity;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository
@Data
public class IngredientesRepository {

   List<IngredienteEntity> ingredientes = new ArrayList<>();

   public void cargarListaIngredientes (List<IngredienteEntity> ingredientesEntity){
      ingredientes = ingredientesEntity;
   }


}
