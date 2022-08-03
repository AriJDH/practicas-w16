package com.bootcamp.deportes.services;

import com.bootcamp.deportes.dtos.PersonaDTO;
import com.bootcamp.deportes.entities.Deporte;
import com.bootcamp.deportes.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonaServices {
    static Persona persona1 = new Persona("Jorge", "Perez", 33, Arrays.asList(DeporteServices.listaDeportes.get(0)));
    static Persona persona2 = new Persona("Pepe", "Gonzalez", 25, Arrays.asList(DeporteServices.listaDeportes.get(0), DeporteServices.listaDeportes.get(1)));
    static Persona persona3 = new Persona("Guillermo", "Bariani", 24, Arrays.asList(DeporteServices.listaDeportes.get(0)));
    static Persona persona4 = new Persona("Cristiano", "Ronaldo", 33, Arrays.asList(DeporteServices.listaDeportes.get(0)));
    static List<Persona> listaPersonas = new ArrayList<>(Arrays.asList(
           persona1,persona2, persona3, persona4
    ));

    public List<PersonaDTO> devolverDeportistas(){
        List<PersonaDTO> listaDeportistas = new ArrayList<>();

        for (Persona persona: listaPersonas){
            PersonaDTO pDTO = new PersonaDTO();
            pDTO.setNombre(persona.getNombre());
            pDTO.setApellido(persona.getApellido());
            List<String> deportes = new ArrayList<>();
            for (Deporte deporte: persona.getDeportesAplicados()){
                deportes.add(deporte.getNombre());
            }
            pDTO.setDeportes(deportes);
            listaDeportistas.add(pDTO);
        }
        return listaDeportistas;
    }
}
