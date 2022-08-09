package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.NombreSintomaDTO;
import com.bootcamp.covid.dto.PersonaDTO;
import com.bootcamp.covid.dto.SintomaDTO;
import com.bootcamp.covid.dto.SintomasDTO;
import com.bootcamp.covid.model.Persona;
import com.bootcamp.covid.model.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCovid {

    List<Sintoma> sintomas = cargaDeSintomas();


    public SintomasDTO allSintomas() {
        List<String> sintomasString = new ArrayList<>();
        sintomas.forEach((x -> sintomasString.add(x.getNombre())));
        return new SintomasDTO(sintomasString);
    }

    public SintomaDTO getSintomaService(NombreSintomaDTO name) {

        SintomaDTO sintomaDTO = new SintomaDTO();
        sintomas.stream().forEach(x -> {
            if (x.getNombre().toLowerCase().equals(name.getNombreSintoma().toLowerCase())) {
                sintomaDTO.setNombreSintoma(x.getNombre());
                sintomaDTO.setNivelDeGravedad(x.getNivelDeGravedad());
            }
        });
        return sintomaDTO;
    }

    public List<PersonaDTO> findRiskPerson(){
        return cargarPersona().stream()
                .filter(p-> p.getEdad()>60 && p.getSintomas().size()>=1)
                .map(p->new PersonaDTO(p.getNombre(),p.getApellido(),p.getSintomas()))
                .collect(Collectors.toList());
    }

    public static List<Persona> cargarPersona(){
        List<Persona> personas = new ArrayList<>();
        List<Sintoma> sintomas = cargaDeSintomas();

        List<Sintoma> sintomasP1 = new ArrayList<>();
        List<Sintoma> sintomasP2 = new ArrayList<>();
        List<Sintoma> sintomasP3 = new ArrayList<>();

        sintomasP1.add(sintomas.get(3));
        sintomasP2.add(sintomas.get(3));
        sintomasP2.add(sintomas.get(2));


        Persona p1 = new Persona(1L,"Rodrigo","Cifuentes",26,sintomasP1);
        Persona p2 = new Persona(2L,"Gilber","Perez",65,sintomasP2);
        Persona p3 = new Persona(3L,"Manuel","Sandoval",61,sintomasP1);
        Persona p4 = new Persona(3L,"Manuel","Gutierrez",62,sintomasP3);

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        return personas;
    }
    public static List<Sintoma> cargaDeSintomas() {

        List<Sintoma> sintomas = new ArrayList<>();
        sintomas.add(new Sintoma(1,"Fiebre", "Grave"));
        sintomas.add(new Sintoma(2,"Tos", "Leve"));
        sintomas.add(new Sintoma(3,"Dolor Muscular", "Medio"));
        sintomas.add(new Sintoma(4,"Vomito", "Grave"));

        return sintomas;

    }


}
