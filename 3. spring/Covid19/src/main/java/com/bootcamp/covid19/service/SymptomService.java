package com.bootcamp.covid19.service;

import com.bootcamp.covid19.dto.PersonDto;
import com.bootcamp.covid19.dto.SymptonDto;
import com.bootcamp.covid19.model.Person;
import com.bootcamp.covid19.model.Symptom;
import com.bootcamp.covid19.repository.PersonDosRepository;
import com.bootcamp.covid19.repository.PersonRepository;
import com.bootcamp.covid19.repository.SymptomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomService {

    PersonRepository repository;
    Person person;


    public List<SymptonDto> findSysptomsDto(){

        return SymptomRepository
                .putSymptoms()
                .stream()
                .map(symptom -> new SymptonDto(symptom.getName(), symptom.getNivelGravedad()))
                .collect(Collectors.toList());
    }

    public SymptonDto findSystomDto(String name){

        Symptom symptom = SymptomRepository.findSymptoms(name);

        SymptonDto symptonDto = new SymptonDto(symptom.getName(), symptom.getNivelGravedad());

        return  symptonDto;

    }

    public List<PersonDto> findPersonSymptom(){

        return PersonRepository
                .putPeople()
                .stream()
                .filter(person -> person.getAge()>=60)
                .map(person -> new PersonDto(person.getName(), person.getLastName(), person.getAge(), person.getSymptom().getName(), person.getSymptom().getNivelGravedad()))
                .collect(Collectors.toList());
    }
}
