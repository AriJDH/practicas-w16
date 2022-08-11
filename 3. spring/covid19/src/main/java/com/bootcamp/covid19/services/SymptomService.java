package com.bootcamp.covid19.services;

import com.bootcamp.covid19.dto.RiskPersonDTO;
import com.bootcamp.covid19.dto.SymptomDTO;
import com.bootcamp.covid19.entities.Person;
import com.bootcamp.covid19.entities.Symptom;
import com.bootcamp.covid19.repos.PersonRepo;
import com.bootcamp.covid19.repos.SymptomRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomService {

    public List<SymptomDTO> getSymptoms(){
        return SymptomRepo.getSymptoms().stream()
                .map((x) -> new SymptomDTO(x.getCode(), x.getName(), x.getSeverityLevel()))
                .collect(Collectors.toList());
    }

    public SymptomDTO getSymptom(String name){
        Symptom symptom = SymptomRepo.getSymptom(name);
        return new SymptomDTO(symptom.getCode(), symptom.getName(), symptom.getSeverityLevel());
    }


    public List<RiskPersonDTO> getRiskPersons(){
        List<RiskPersonDTO> persons = new ArrayList<>();
        for (Person person : PersonRepo.getPersons()) {
            if (!person.getSymptoms().isEmpty() && person.getEdad()>60) {
                List<String> symptoms = new ArrayList<>();
                person.getSymptoms().forEach(s -> symptoms.add(SymptomRepo.getSymptom(s).getName()));
                persons.add(new RiskPersonDTO(person.getName(), person.getLastname(), symptoms));
            }
        }

        return  persons;
    }
}
