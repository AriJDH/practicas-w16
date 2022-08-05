package com.mercadolibre.bootcamp.covid19.repository;

import com.mercadolibre.bootcamp.covid19.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonRepository {

    private List<Person> people = new ArrayList<>();

    private List<Person> getRiskPeople(){
        return people
                .stream()
                .filter(Person::isriskPerson)
                .collect(Collectors.toList());
    }
}
