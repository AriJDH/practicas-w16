package com.javaW16.deportistas.repository;

import java.util.ArrayList;

import com.javaW16.deportistas.entities.Deporte;
import com.javaW16.deportistas.entities.Deportista;
import com.javaW16.deportistas.entities.Persona;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class Repository {

   ArrayList<Deporte> deporteRepository;
   ArrayList<Persona> personaRepository;
   ArrayList<Deportista> deportistaRepository;

   public void addDeporte(Deporte deporte) {
      deporteRepository.add(deporte);
   }

   public void addPersona(Persona persona) {
      personaRepository.add(persona);
   }

   public void addDeportista(Deportista deportista) {
      deportistaRepository.add(deportista);
   }

}
