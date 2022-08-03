package com.example.covid19.Service;

import com.example.covid19.DTO.SintomaDTO;
import com.example.covid19.DTO.SintomaPersonaDTO;
import com.example.covid19.Repository.RepositoryPersona;
import com.example.covid19.Repository.RepositorySintoma;

import java.util.List;
import java.util.stream.Collectors;

public class SerCovid {
    public List<SintomaDTO> allSintomas(){
        return RepositorySintoma.allSintomas().stream()
                .map(sintoma-> new SintomaDTO(sintoma.getCodigo(),sintoma.getNombre(),sintoma.getNivel_de_gravedad()))
                .collect(Collectors.toList());
    }
    public String sintomaPorNombre(String nombre){
        return RepositorySintoma.allSintomas().stream()
                .filter(sintoma ->sintoma.getNombre().equals(nombre))
                .findFirst()
                .get().getNivel_de_gravedad();
    }

    public List<SintomaPersonaDTO> allPersonasPeligro(){
        return RepositoryPersona.allPersonas().stream()
                .filter(persona ->persona.getEdad()>60)
                .filter(persona->persona.getSintomas().size()>=1)
                .map(p ->new SintomaPersonaDTO(p.getNombre(),p.getApellido()))
                .collect(Collectors.toList());
    }

}
