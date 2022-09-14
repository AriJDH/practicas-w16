package com.meli.covid.repository;

import com.meli.covid.Util.Util;
import com.meli.covid.dto.PersonDto;
import com.meli.covid.entity.Person;
import com.meli.covid.entity.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository implements IPersonRepository {

    List<Person> people;

    public PersonRepository() {
        people = new ArrayList<>();
        loadData();
    }

    public void loadData() {
        List<Symptom> symptomsPepito = new ArrayList<>();
        symptomsPepito.add(new Symptom(1,"Fiebre", 2));
        symptomsPepito.add(new Symptom(2,"Tos", 3));

        List<Symptom> symptomsArvey = new ArrayList<>();
        symptomsArvey.add(new Symptom(1,"Fiebre", 2));
        symptomsArvey.add(new Symptom(2,"Tos", 3));

        people.add(new Person(1, "Anggy", "Arguello", 24, new ArrayList<>()));
        people.add(new Person(2, "Pepito", "Perez", 61, symptomsPepito));
        people.add(new Person(3, "Arvey", "Murcia", 23, symptomsArvey));
        people.add(new Person(4, "Fulano", "Sultana", 61, new ArrayList<>()));
    }

    @Override
    public List<PersonDto> findRiskPerson() {
        List<PersonDto> peopleDto = people.stream().filter(person -> person.getAge() > 60 && person.getSymptoms().size() > 0).map(person -> Util.castTo(person, PersonDto.class)).collect(Collectors.toList());
        return peopleDto;
    }
}
