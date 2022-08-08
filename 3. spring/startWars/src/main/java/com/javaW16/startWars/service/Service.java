package com.javaW16.startWars.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import com.javaW16.startWars.dto.RequestPersonajeDTO;
import com.javaW16.startWars.dto.ResponsePersonajeDto;
import com.javaW16.startWars.repository.PersonajeRepository;
import com.javaW16.startWars.utilis.PersonajeUtils;

@org.springframework.stereotype.Service
public class Service {

   @Autowired
   PersonajeRepository repository;
   @Autowired
   private PersonajeUtils utils;

   public void cargaPersonajes(List<RequestPersonajeDTO> body) {
      repository.cargarPersonaje(body);

   }

   public List<ResponsePersonajeDto> getPersonaje(String name) {
      return repository.getPersonajes().stream()
            .filter(personaje -> personaje.getName().contains(name))
            .map(personaje -> utils.converToPersonajeDTO(personaje)).collect(Collectors.toList());

   }
}
