package com.bootcamp.covid19.service;


import com.bootcamp.covid19.dtos.NivelDeGavedadSintomaDTO;
import com.bootcamp.covid19.dtos.PersonasDeRiesgoDTO;
import com.bootcamp.covid19.dtos.SintomasDTO;
import com.bootcamp.covid19.entities.Persona;
import com.bootcamp.covid19.entities.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CovidSVC {

    private List<Sintoma> sintomas;
    private List<Persona> personas;

    public CovidSVC() {
        init();
    }

    private void init(){

        sintomas = new ArrayList<>();
        personas = new ArrayList<>();

        Sintoma sintoma1 = new Sintoma(1548L,"Tos","Bajo");
        Sintoma sintoma2 = new Sintoma(1584L,"Fiebre","Medio");
        Sintoma sintoma3 = new Sintoma(1354L,"Dificultad para respirar","Alto");
        Sintoma sintoma4 = new Sintoma(1244L,"Fatiga","Bajo");
        Sintoma sintoma5 = new Sintoma(1212L,"Congestion Nasal","Bajo");

        sintomas.add(sintoma1);
        sintomas.add(sintoma2);
        sintomas.add(sintoma3);
        sintomas.add(sintoma4);
        sintomas.add(sintoma5);

        Persona persona1 = new Persona(158648L,"Pedro","Perez", 70, new Sintoma[]{});
        Persona persona2 = new Persona(155847L,"Martin","Martinez", 65, new Sintoma[]{sintoma1,});
        Persona persona3 = new Persona(167894L,"Juana","Juanez", 60, new Sintoma[]{sintoma2});
        Persona persona4 = new Persona(187954L,"Rodrigo","Rodriguez", 35, new Sintoma[]{sintoma3});
        Persona persona5 = new Persona(123456L,"Dominga","Dominguez", 18, new Sintoma[]{sintoma4});


        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
        personas.add(persona5);

    }

    public List<SintomasDTO> findAllSymptoms(){

        List<SintomasDTO> dtoList = new ArrayList<>();

        sintomas.forEach(x ->{
                    SintomasDTO newSymptom = new SintomasDTO(x.getCodigo(), x.getNombre(), x.getNivel_de_gravedad());
                    dtoList.add(newSymptom);
                    });

        return dtoList;
    }

    public NivelDeGavedadSintomaDTO findSymptom(String name){

        Optional<Sintoma> sintomaBuscado = sintomas.stream().
                filter(x -> x.getNombre().equalsIgnoreCase(name)).findFirst();

        if(sintomaBuscado.isPresent()){
            return new NivelDeGavedadSintomaDTO(sintomaBuscado.get().getNivel_de_gravedad());
        }else{
            return null;
        }
    }

    public List<PersonasDeRiesgoDTO> personasDeRiesgo(){

        List<PersonasDeRiesgoDTO> dtoList =  new ArrayList<>();

        List<Persona> lista = personas.stream().filter(x ->
                x.getEdad()>=60&&x.getSintomasAsociados().length>0).
                collect(Collectors.toList());

        lista.forEach(x ->{
                    PersonasDeRiesgoDTO newRiskPerson = new PersonasDeRiesgoDTO(x.getNombre(), x.getApellido());
                    dtoList.add(newRiskPerson);
                });

        return dtoList;
    }
}
