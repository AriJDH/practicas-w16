package com.meli.covid.service;

import com.meli.covid.dtos.Pasientedtos;
import com.meli.covid.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaService {

    SymptomService sintomas= new SymptomService();

    private List<Pasientedtos> listapersonas=List.of(new Pasientedtos(new Persona(1,"Sebastian","Riquelme",60),sintomas.getSintomas()));



    public List<Pasientedtos> getRiskPerson()
    {
        return listapersonas.stream().filter(x-> x.getPersona().getEdad()>=60 && x.getSintomas().size()>0).collect(Collectors.toList());
    }







}
