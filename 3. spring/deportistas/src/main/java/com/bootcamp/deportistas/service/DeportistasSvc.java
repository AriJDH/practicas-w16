package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dtos.DeporteDto;
import com.bootcamp.deportistas.dtos.NivelDeporteDTO;
import com.bootcamp.deportistas.dtos.PersonaDto;
import com.bootcamp.deportistas.entities.Deporte;
import com.bootcamp.deportistas.entities.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class DeportistasSvc {

    public List<Deporte> sportsList;
    public List<Persona> personList;

    public DeportistasSvc() {
        intancias();
    }

    private void intancias(){

        sportsList = new ArrayList<>();
        personList = new ArrayList<>();

        Deporte deporte1 = new Deporte("Futbol","Medio");
        Deporte deporte2 = new Deporte("Voleibol","Avanzado");
        Deporte deporte3 = new Deporte("Futbol","Principiante");
        Deporte deporte4 = new Deporte("Rugby","Medio");

        Persona persona1 = new Persona("Manuel","Perez",25,deporte1);
        Persona persona2 = new Persona("Federico","Ferreira",35,deporte2);
        Persona persona3 = new Persona("Martin","Martinez",22,deporte3);
        Persona persona4 = new Persona("Rodrigo","Rodriguez",30,deporte4);

        personList.add(persona1);
        personList.add(persona2);
        personList.add(persona3);
        personList.add(persona4);

        sportsList.add(deporte1);
        sportsList.add(deporte2);
        sportsList.add(deporte3);
        sportsList.add(deporte4);

    }

    public List<DeporteDto> listarDeportes(){

        List<DeporteDto> listDtos = new ArrayList<>();

        sportsList.forEach(x->{
            DeporteDto nuevoDeporte = new DeporteDto(x.getNombre(), x.getNivel());
            listDtos.add(nuevoDeporte);
        });
        return listDtos;
    }

    public List<NivelDeporteDTO> buscarDeporte(String nombre){

        List<Deporte> deporte = sportsList.stream()
                .filter(x -> x.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());

        List<NivelDeporteDTO> listDtos = new ArrayList<>();

        deporte.forEach(x->{
            NivelDeporteDTO nuevoDeporte = new NivelDeporteDTO(x.getNivel());
            listDtos.add(nuevoDeporte);
        });

        return listDtos;
    }

    public List<PersonaDto> listarPersonas(){

        List<PersonaDto> listDtos = new ArrayList<>();

        personList.forEach(x->{
            PersonaDto nuevaPersona = new PersonaDto(x.getNombre(), x.getApellido(), x.getDeporte().getNombre());
            listDtos.add(nuevaPersona);
        });
        return listDtos;

    }
}
