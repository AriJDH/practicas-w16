package com.bootcamp.covid19.service;

import com.bootcamp.covid19.dto.PersonDto;
import com.bootcamp.covid19.dto.SymptomDto;
import com.bootcamp.covid19.entities.Symptom;
import com.bootcamp.covid19.repository.PersonRepo;
import com.bootcamp.covid19.repository.SymptomRepo;

import java.util.List;
import java.util.stream.Collectors;

public class Covid19Service {

    public List<SymptomDto> getAllSymptoms(){
        return SymptomRepo.getAllSymptons().stream().map(symptom -> new SymptomDto(symptom.getName(), symptom.getSeverityLevel())).collect(Collectors.toList());
    }

    public SymptomDto getSymptomByName(String name){
        Symptom symptom = SymptomRepo.getSymptomByName(name);
        return new SymptomDto(symptom.getName(), symptom.getSeverityLevel());
    }

    public List<PersonDto> getPersonsWithRisk(){

      return   PersonRepo.getAllPersons().stream()
              .filter(person -> person.getAge() > 60)
              .filter(person -> !person.getSymptomList().isEmpty())
              .collect(Collectors.toList())
              .stream().map(person -> new PersonDto(person.getName(), person.getLastName()))
              .collect(Collectors.toList());

    }

}
