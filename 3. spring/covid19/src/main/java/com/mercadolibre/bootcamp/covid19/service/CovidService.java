package com.mercadolibre.bootcamp.covid19.service;

import com.mercadolibre.bootcamp.covid19.dtos.PersonDto;
import com.mercadolibre.bootcamp.covid19.dtos.SymptomDto;
import com.mercadolibre.bootcamp.covid19.models.Person;
import com.mercadolibre.bootcamp.covid19.models.Symptom;
import com.mercadolibre.bootcamp.covid19.repository.PersonRepository;
import com.mercadolibre.bootcamp.covid19.repository.SymptomRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class CovidService {

    private PersonRepository personRepository;
    private SymptomRepository symptomRepository;

    @Autowired
    public CovidService(PersonRepository personRepository, SymptomRepository symptomRepository) {
        this.personRepository = personRepository;
        this.symptomRepository = symptomRepository;

        Symptom simp1 = new Symptom(1, "Tos", "Suave");
        Symptom simp2 = new Symptom(2, "Perdida olfato", "Total");
        Symptom simp3 = new Symptom(3, "Fiebre", "Media");

        symptomRepository.add(simp1);
        symptomRepository.add(simp2);
        symptomRepository.add(simp3);

        List<Symptom> symps1 = new ArrayList<>();
        symps1.add(simp1);

        List<Symptom> symps2 = new ArrayList<>();
        symps2.add(simp2);
        symps2.add(simp3);

        Person person1 = new Person(1, "Ricardito", "Mocked", 22, symps1);
        Person person2 = new Person(1, "Javi", "Sano", 60, symps2);

        personRepository.add(person1);
        personRepository.add(person2);

    }

    public List<SymptomDto> getAllSymptoms() {
        return symptomRepository.getAllSymptoms()
                .stream()
                .map(sim -> new SymptomDto(sim.getName(), sim.getLevelOfSeverity()))
                .collect(Collectors.toList());
    }

    public SymptomDto getSymptomByName(String name){
        Symptom symRecovered = symptomRepository.getByName(name);
        return new SymptomDto(symRecovered.getName(), symRecovered.getLevelOfSeverity());
    }

    public List<PersonDto> getRiskPersons(){
        return personRepository.getRiskPeople()
                .stream().map(p -> new PersonDto(p.getName(),p.getLastName(),p.getSymptoms()))
                .collect(Collectors.toList());
    }
}
