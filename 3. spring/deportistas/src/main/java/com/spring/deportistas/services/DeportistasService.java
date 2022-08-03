package com.spring.deportistas.services;

import com.spring.deportistas.DTOs.DeporteDTO;
import com.spring.deportistas.DTOs.PersonaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeportistasService {

    private List<DeporteDTO> listaDeportes;
    private List<PersonaDTO> listaPersonas;

    public DeportistasService(){
        listaDeportes = new ArrayList<>();
        listaDeportes.add(new DeporteDTO("Futbol", 3));
        listaDeportes.add(new DeporteDTO("Basketball", 2));
        listaDeportes.add(new DeporteDTO("Tenis", 3));

        listaPersonas = new ArrayList<>();
        listaPersonas.add(new PersonaDTO("Lucas", "Abbiatici", 23, List.of(new DeporteDTO("Futbol", 3), new DeporteDTO("Basketball", 2))));
        listaPersonas.add(new PersonaDTO("Andres", "Fernandez", 23, List.of(new DeporteDTO("Basketball", 2))));
    }

    public List<DeporteDTO> listarDeportes(){
        return listaDeportes;
    }

    public DeporteDTO listarDeportexNombre(String nombre){

        List<DeporteDTO> deporte = listaDeportes.stream().filter(d -> d.getNombre().equals(nombre)).collect(Collectors.toList());

        if(deporte.size() == 1){
            return deporte.get(0);
        } else {
            return new DeporteDTO(null, null);
        }

    }

    public List<PersonaDTO> listarPersonas(){
        return listaPersonas;
    }

}
