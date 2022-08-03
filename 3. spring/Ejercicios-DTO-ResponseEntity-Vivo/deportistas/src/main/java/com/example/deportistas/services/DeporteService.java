package com.example.deportistas.services;

import com.example.deportistas.dtos.DeporteDto;
import com.example.deportistas.dtos.DeportistaDto;
import com.example.deportistas.entities.Deporte;
import com.example.deportistas.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteService {

    private final List<Deporte> listaDeporte = new ArrayList<>();
    private final List<Persona> listaPersona = new ArrayList<>();

    public DeporteService() {

        Deporte deporteUno = Deporte.builder().nombre("Tenis").nivel(1).build();
        Deporte deporteDos = Deporte.builder().nombre("Baloncesto").nivel(2).build();
        Deporte deporteTres = Deporte.builder().nombre("Voleibol").nivel(2).build();

        listaDeporte.add(deporteUno);
        listaDeporte.add(deporteDos);
        listaDeporte.add(deporteTres);


        listaPersona.add(Persona.builder().nombre("Tomas ").apellido("Doe").build());
        listaPersona.add(Persona.builder().nombre("Santiago").apellido("Silva").deporte(deporteUno).build());
        listaPersona.add(Persona.builder().nombre("Manuel").apellido("Gaona").deporte(deporteTres).build());


    }



    public List<DeporteDto> obtenerTodosDeportes(){

        return listaDeporte.stream().map(deporte->{
            DeporteDto deporteDto = new DeporteDto();
            deporteDto.setNivel(deporte.getNivel());
            deporteDto.setNombre(deporte.getNombre());

            return deporteDto;

        }).collect((Collectors.toList()));

    }

    public DeporteDto obtenerDeporte(String nombre){
        Deporte deportes = listaDeporte.stream()
                .filter(deporte-> deporte.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);

        if(listaDeporte == null)
            return null;

        DeporteDto deporteDto = new DeporteDto();
        deporteDto.setNombre(deportes.getNombre());
        deporteDto.setNivel(deportes.getNivel());

        return deporteDto;


    }

    public List<DeportistaDto> obtenerDeportePersona(){

        return listaPersona.stream().filter(persona -> persona.getDeporte() != null)
                .map(persona -> {
                    DeportistaDto personaDto = new DeportistaDto();
                    personaDto.setNombre(persona.getNombre());
                    personaDto.setApellido(persona.getApellido());
                    personaDto.setDeporte(persona.getDeporte().getNombre());

                    return personaDto;
                }).collect(Collectors.toList());

    }

}
