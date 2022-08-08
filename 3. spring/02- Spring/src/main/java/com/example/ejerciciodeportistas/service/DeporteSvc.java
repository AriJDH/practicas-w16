package com.example.ejerciciodeportistas.service;

import com.example.ejerciciodeportistas.dto.deporte.DeporteDto;
import com.example.ejerciciodeportistas.dto.deporte.DeporteNivelDto;
import com.example.ejerciciodeportistas.dto.deporte.PersonaDto;
import com.example.ejerciciodeportistas.entities.deporte.Deporte;
import com.example.ejerciciodeportistas.entities.deporte.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeporteSvc {
    List<Persona> listaPersona;
    List<Deporte> listaDeportes;

    public DeporteSvc() {
        llenadoVariable();
    }
    private void llenadoVariable(){
        this.listaDeportes = new ArrayList<>();
        this.listaPersona = new ArrayList<>();
        Deporte deporte1 = new Deporte("Soccer", "Medio");
        Deporte deporte2 =new Deporte("Tenis", "Alto");
        Deporte deporte3 =new Deporte("Natación", "Básico");

        this.listaDeportes.add(deporte1);
        this.listaDeportes.add(deporte2);
        this.listaDeportes.add(deporte3);

        this.listaPersona.add(new Persona("Pedro", "Lara", 26,deporte1));
        this.listaPersona.add(new Persona("Julio", "Troncoso", 21,deporte2));
        this.listaPersona.add(new Persona("Maria", "Lopez", 25,deporte3));
    }

    public List<DeporteDto> listarDeportes(){
        List<DeporteDto> listaDtos = new ArrayList<>();

        listaDeportes.forEach(x->{
            DeporteDto  nuevoDeporte = new DeporteDto(x.getNombre(),x.getNivel());
            listaDtos.add(nuevoDeporte);
        });

        return listaDtos;
    }

    public DeporteNivelDto buscarDeporte(String nombre){
        Optional<Deporte> deporteBuscado = listaDeportes.stream().filter(x->x.getNombre().equalsIgnoreCase(nombre)).findFirst();
        if(deporteBuscado.isPresent()){
            return new DeporteNivelDto(deporteBuscado.get().getNivel());
        }else{
            return null;
        }
    }
    public List<PersonaDto> listarPersonas(){
        List<PersonaDto> listadoPersonasDto = new ArrayList<>();
        listaPersona.forEach(x-> {
            PersonaDto nuevaPersona = new PersonaDto(x.getNombre(),x.getApellido(),x.getDeporteQueRealiza().getNombre());
            listadoPersonasDto.add(nuevaPersona);
        });
        return listadoPersonasDto;
    }
}
