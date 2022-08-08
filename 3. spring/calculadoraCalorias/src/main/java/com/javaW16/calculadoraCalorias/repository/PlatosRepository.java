package com.javaW16.calculadoraCalorias.repository;

import java.util.ArrayList;
import java.util.List;

import com.javaW16.calculadoraCalorias.entities.PlatoEntity;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository
@Data

public class PlatosRepository {

   List<PlatoEntity> platos = new ArrayList<>();

   public void cargarListaPlatos (PlatoEntity platoEntity){
      platos.add(platoEntity);
   }

}
