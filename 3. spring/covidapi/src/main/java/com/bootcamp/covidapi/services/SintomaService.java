package com.bootcamp.covidapi.services;

import com.bootcamp.covidapi.dto.PersonaDto;
import com.bootcamp.covidapi.dto.SintomaDto;
import com.bootcamp.covidapi.models.Persona;
import com.bootcamp.covidapi.models.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SintomaService {

    public static List<Sintoma> cargarSymptom(){
        List<Sintoma> sintomas = new ArrayList<>();
        Sintoma s1 = new Sintoma("COV-SAR-19","Covid 19","GRAVE");
        Sintoma s2 = new Sintoma("MONKEY-22","Viruela del mono","GRAVE");
        Sintoma s3 = new Sintoma("VIH","Virus de inmuno deficiencia","medio");
        Sintoma s4 = new Sintoma("REF-23","Resfriado comun","BAJO");

        sintomas.add(s1);
        sintomas.add(s2);
        sintomas.add(s3);
        sintomas.add(s4);

        return sintomas;
    }


    public static List<Persona> cargarPersona(){
        List<Persona> personas = new ArrayList<>();
        List<Sintoma> sintomas = cargarSymptom();
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

    public List<SintomaDto> getSymptoms(){
        return cargarSymptom().stream().map(s->new SintomaDto(s.getCodigo(),s.getNombre(),s.getNIVEL_DE_GRAVEDAD())).collect(Collectors.toList());
    }

    public SintomaDto findSymptoms(String name){
        List<SintomaDto> sintomaDtos = cargarSymptom().stream().filter(s-> s.getNombre().equals(name)).map(s->new SintomaDto(s.getCodigo(),s.getNombre(),s.getNIVEL_DE_GRAVEDAD())).collect(Collectors.toList());;
       if(sintomaDtos.size()>0){
           return sintomaDtos.get(0);
       }
        return null;
    }

    public List<PersonaDto> findRiskPerson(){
        return cargarPersona().stream().filter(p-> p.getEdad()>60 && p.getSintomas().size()>=1).map(p->new PersonaDto(p.getNombre(),p.getApellido(),p.getSintomas())).collect(Collectors.toList());
    }
}
