package com.example.ejercicio2.services;

import com.example.ejercicio2.entities.Persona;
import com.example.ejercicio2.entities.Sintomas;
import com.example.ejercicio2.entitisDto.PersonaDTO;
import com.example.ejercicio2.entitisDto.SintomaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SintomasServices {
   private final  List<Persona> personaList=new ArrayList<>();
   private final  List<Sintomas> sintomasList=new ArrayList<>();

    public SintomasServices() {
        carga();
    }

    public void carga(){
       Sintomas s1= Sintomas.builder().codigo(1).nombre("covid").nivelDeGravedad(10).build();
       Sintomas s2= Sintomas.builder().codigo(2).nombre("tos").nivelDeGravedad(3).build();
       Sintomas s3= Sintomas.builder().codigo(1).nombre("moco").nivelDeGravedad(4).build();
       Sintomas s4= Sintomas.builder().codigo(1).nombre("dolor de cabeza").nivelDeGravedad(8).build();

       sintomasList.add(s1);
       sintomasList.add(s2);
       sintomasList.add(s3);
       sintomasList.add(s4);

       personaList.add(Persona.builder().id(1).nombre("emanuel").apellido("rivero").sintoma(s1).edad(62).build());
       personaList.add(Persona.builder().id(2).nombre("pamela").apellido("pereyra").sintoma(s2).edad(64).build());
       personaList.add(Persona.builder().id(1).nombre("saul").apellido("goodman").sintoma(s4).edad(61).build());
       personaList.add(Persona.builder().id(1).nombre("gonzalo").apellido("di pierro").edad(69).build());
   }

    public List<SintomaDTO> getAllSintomasTotales(){
       return sintomasList.stream().map(s->{
           SintomaDTO sintomaDto=new SintomaDTO(s);
           return sintomaDto;
       }).collect(Collectors.toList());
    }

    public SintomaDTO getSintoma(String name){
        Sintomas sintoma =sintomasList.stream().filter(e-> e.getNombre().equals(name)).findFirst().orElse(null);
        System.out.println(sintoma);
        SintomaDTO sintomaDTO=new SintomaDTO(sintoma);
        return sintomaDTO;
    }

    public List<PersonaDTO> getPersonaWithSintoma(){
        List<Persona> persona= personaList.stream().filter(p -> p.getEdad()>=60 && p.getSintoma()!=null)
                .collect(Collectors.toList());
        List<PersonaDTO> personaDt= persona.stream().map(p->{
            PersonaDTO personaDto=new PersonaDTO();
            personaDto.setSintoma(p.getSintoma().getNombre());
            personaDto.setNombre(p.getNombre());
            personaDto.setApellido(p.getApellido());
            personaDto.setEdad(p.getEdad());
            return personaDto;
        }).collect(Collectors.toList());
        return personaDt;
    }







}
