package com.example.springcovid19.service;

import com.example.springcovid19.entity.Persona;
import com.example.springcovid19.entity.Sintoma;
import com.example.springcovid19.entityDTO.PersonaDTO;
import com.example.springcovid19.entityDTO.SintomaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
   private final  List<Persona> listaDePersonas;
   private final  List<Sintoma> listaDeSintomas;

    public Service() {
        this.listaDePersonas = new ArrayList();
        this.listaDeSintomas = new ArrayList();

        cargarDatos();
    }

    public void cargarDatos(){
       Sintoma sintoma1 = Sintoma.builder().codigo(1).nombre("fiebre").nivelDeGravedad(10).build();
       Sintoma sintoma2 = Sintoma.builder().codigo(2).nombre("tos").nivelDeGravedad(3).build();
       Sintoma sintoma3 = Sintoma.builder().codigo(3).nombre("dolor de garganta").nivelDeGravedad(4).build();
       Sintoma sintoma4 = Sintoma.builder().codigo(4).nombre("dolor de cabeza").nivelDeGravedad(8).build();

       this.listaDeSintomas.add(sintoma1);
       this.listaDeSintomas.add(sintoma2);
       this.listaDeSintomas.add(sintoma3);
       this.listaDeSintomas.add(sintoma4);

       this.listaDePersonas.add(Persona.builder().id(1).nombre("emanuel").apellido("rivero").sintoma(sintoma1).edad(62).build());
       this.listaDePersonas.add(Persona.builder().id(2).nombre("pamela").apellido("pereyra").sintoma(sintoma2).edad(64).build());
       this.listaDePersonas.add(Persona.builder().id(3).nombre("saul").apellido("goodman").sintoma(sintoma4).edad(61).build());
       this.listaDePersonas.add(Persona.builder().id(4).nombre("gonzalo").apellido("di pierro").edad(69).build());
   }

    public List<SintomaDTO> getAllSintomas(){
       return this.listaDeSintomas.stream().map(s -> {
           SintomaDTO sintomaDto = new SintomaDTO(s);
           return sintomaDto;
       }).collect(Collectors.toList());
    }

    public SintomaDTO getSintoma(String name){
        Sintoma sintoma = this.listaDeSintomas.stream().filter(s -> s.getNombre().equals(name)).findFirst().orElse(null);
        SintomaDTO sintomaDTO = new SintomaDTO(sintoma);

        return sintomaDTO;
    }

    public List<PersonaDTO> getPersonaWithSintoma(){
        List<Persona> persona = this.listaDePersonas.stream()
                                                    .filter(p -> p.getEdad()>=60 && p.getSintoma()!=null)
                                                    .collect(Collectors.toList());
        List<PersonaDTO> listaDePersonaDto = persona.stream().map(p->{
            PersonaDTO personaDto=new PersonaDTO();
            personaDto.setSintoma(p.getSintoma().getNombre());
            personaDto.setNombre(p.getNombre());
            personaDto.setApellido(p.getApellido());
            personaDto.setEdad(p.getEdad());
            return personaDto;
        }).collect(Collectors.toList());

        return listaDePersonaDto;
    }
}
