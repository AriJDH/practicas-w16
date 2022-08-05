package com.covid19.covid.service;

import com.covid19.covid.DTO.PersonDTO;
import com.covid19.covid.DTO.SymptomDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidService {

    private List<SymptomDTO> symptoms;
    private List<PersonDTO> people;

    public CovidService() {
        symptoms = new ArrayList<>();

        SymptomDTO cough = new SymptomDTO("Cough",2);
        SymptomDTO fever = new SymptomDTO("Fever",4);
        SymptomDTO taste = new SymptomDTO("Loss of taste or smell",3);
        SymptomDTO breath = new SymptomDTO("Difficulti breathing",5);

        symptoms.add(cough);
        symptoms.add(fever);
        symptoms.add(taste);
        symptoms.add(breath);

        people = new ArrayList<PersonDTO>();
        people.add(new PersonDTO("Marcos","Rojas",68, Arrays.asList(cough,taste)));
        people.add(new PersonDTO("Juan","Perez",38, Arrays.asList(breath,fever)));
        people.add(new PersonDTO("José","Romero",82, Arrays.asList(cough,fever)));
    }

    public List<SymptomDTO> listSymptom(){
        return symptoms;
    }

    public SymptomDTO consultSymptom(String name){

        List<SymptomDTO> symptom = symptoms.stream()
                .filter(symptomDTO -> symptomDTO.getName().equals(name))
                .collect(Collectors.toList());

        if (symptom.size() == 1){
            return symptom.get(0);
        }
        else{
            return null;
        }
    }

    public List<PersonDTO> listPersonAtRisk(){
        List<PersonDTO> peopleRisk;
        peopleRisk = people.stream().filter(person -> person.getAge()>=60).collect(Collectors.toList());

        return peopleRisk;
    }

}

