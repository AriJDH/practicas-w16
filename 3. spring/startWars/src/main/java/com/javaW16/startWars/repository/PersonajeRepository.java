package com.javaW16.startWars.repository;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaW16.startWars.utilis.PersonajeUtils;
import com.javaW16.startWars.dto.RequestPersonajeDTO;
import com.javaW16.startWars.entity.Personaje;

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
