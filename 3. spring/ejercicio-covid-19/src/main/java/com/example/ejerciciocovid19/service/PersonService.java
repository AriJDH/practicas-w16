package com.example.ejerciciocovid19.service;

import com.example.ejerciciocovid19.model.Person;
import com.example.ejerciciocovid19.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private static final Integer RISK_PERSON_AGE = 60;
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getRiskPersons() {
        return personRepository.getAll().stream().filter(person -> person.getAge() > RISK_PERSON_AGE).collect(Collectors.toList());
    }
}
