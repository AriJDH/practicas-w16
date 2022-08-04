package com.bootcamp.practico.service;

import com.bootcamp.practico.dto.RiskPersonDto;
import com.bootcamp.practico.dto.SymptomDto;
import com.bootcamp.practico.entity.Symptom;
import com.bootcamp.practico.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HealthService {

    @Autowired
    private HealthRepository repository;


    public List<SymptomDto> findSymptom() {
        List<SymptomDto> allSymptom = new ArrayList<>();
        repository.getSymptoms().stream().forEach(symptom -> allSymptom.add(SymptomDto.builder()
                .name(symptom.getName())
                .level(symptom.getLevel())
                .build()));

        return allSymptom;
    }


    public SymptomDto findSymptomByName(SymptomDto symptomDto) {
        Symptom found = repository.getSymptoms().stream().filter(symptom ->
                symptom.getName().equalsIgnoreCase(symptomDto.getName())).findFirst().orElse(null);
        if (found != null) {
            symptomDto.setLevel(found.getLevel());
            return symptomDto;
        }
        return null;
    }


    public List<RiskPersonDto> findRiskPerson() {
        List<RiskPersonDto> riskPersonDtos = new ArrayList<>();
        repository.getPersons().stream().forEach(person -> {
            if (person.getSymptom() != null && person.getSymptom().size() > 0 && person.getAge() > 60)
                riskPersonDtos.add(RiskPersonDto.builder().name(person.getName()).lastname(person.getLastname()).build());
        });

        return riskPersonDtos;
    }
}
