package com.bootcamp.covid.repository;

import com.bootcamp.covid.model.Persona;
import com.bootcamp.covid.model.Riesgo;
import com.bootcamp.covid.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SintomasRepository implements ISintomasRepository {
    List<Sintoma> sintomaList;
    List<Persona> personaList;

    List<Riesgo> riesgoList;

    public SintomasRepository(){
        sintomaList=new ArrayList<>();
        personaList=new ArrayList<>();
        riesgoList=new ArrayList<>();
        initData();
    }

    @Override
    public List<Sintoma> getAllSintomas() {
        return sintomaList;
    }

    @Override
    public List<Persona> getAllPersonas() {
        return personaList;
    }

    @Override
    public List<Sintoma> getSintomaByName(String name) {
        return sintomaList.stream()
                .filter(s -> s.getNombre().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Riesgo> getGrupoDeRiesgo() {
        return riesgoList.stream().filter(riesgo -> riesgo.getEdad()>60).collect(Collectors.toList());
    }

 /*   @Override
    public List<Persona> getGrupoDeRiesgo() {
        return personaList.stream().filter(persona -> persona.getEdad()>60).collect(Collectors.toList());
    }*/

    //carga listas
    private void initData(){

        Sintoma s1= new Sintoma("C01","Fiebre","Leve");
        Sintoma s2= new Sintoma("C02","Malestar estomacal","Medio");
        Sintoma s3= new Sintoma("C03","Dolor de Cabeza","Alto");
        Sintoma s4= new Sintoma("C04","Mareos","Leve");

        this.sintomaList.addAll(Arrays.asList(s1,s2,s3,s4));

        Persona p1 = new Persona("1","Manuel","Mengano",30);
        Persona p2 = new Persona("2","Vicente","Fernandez",70);
        Persona p3 = new Persona("3","Alejandro","Fernandez",40);
        Persona p4 = new Persona("4","Gilberto","SantaRosa",45);

        this.personaList.addAll(Arrays.asList(p1,p2,p3,p4));



        Riesgo r1 = new Riesgo("2","Vicente","Fernandez",70,sintomaList);
        this.riesgoList.add(r1);

    }


}
