package com.spring.covid19.services;

import com.spring.covid19.DTOs.PersonaDTO;
import com.spring.covid19.DTOs.SintomaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Covid19Service {

    List<SintomaDTO> listaSintomas;
    List<PersonaDTO> listaPersonas;

    public Covid19Service(){
        listaSintomas = new ArrayList<>();
        listaSintomas.add(new SintomaDTO(1, "Resfrío", 2));
        listaSintomas.add(new SintomaDTO(2, "Fiebre", 5));
        listaSintomas.add(new SintomaDTO(3, "Dolores musculares", 4));

        listaPersonas = new ArrayList<>();
        listaPersonas.add(new PersonaDTO(1, "Lucas", "Abbiatici", 23, List.of(listaSintomas.get(0), listaSintomas.get(2))));
        listaPersonas.add(new PersonaDTO(2, "Eduardo", "Sanchez", 68, listaSintomas));
        listaPersonas.add(new PersonaDTO(3, "Javier", "Fernandez", 81, new ArrayList<>()));

    }

    public List<SintomaDTO> listarSintomas(){
        return listaSintomas;
    }

    public SintomaDTO listarSintomaxNombre(String name){
        List<SintomaDTO> sintoma = listaSintomas.stream().filter(s -> s.getNombre().equals(name)).collect(Collectors.toList());

        if(sintoma.size() == 1){
            return sintoma.get(0);
        } else {
            return new SintomaDTO(null, null, null);
        }
    }

    public List<PersonaDTO> listarPersonasGrupoRiesgo(){

        List<PersonaDTO> listaRiesgo = listaPersonas.stream().filter(p -> p.getEdad() > 60 && !p.getListaSintomas().isEmpty()).collect(Collectors.toList());

        if(listaRiesgo.isEmpty()){
            return new ArrayList<>(List.of(new PersonaDTO(null, null, null, null, null)));
        } else {
            return listaRiesgo;
        }
    }

}
