package com.bootcamp.practico.repository;

import com.bootcamp.practico.dto.RequestPersonajeDTO;
import com.bootcamp.practico.entity.Personaje;
import com.bootcamp.practico.utilis.PersonajeUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class PersonajeRepository {

   @Autowired
   private PersonajeUtils utils;
   private List<Personaje> personajes = new ArrayList<>();

   public void cargarPersonaje(List<RequestPersonajeDTO> body) {

      personajes = utils.convertToPersonaje(body);
   }
}
