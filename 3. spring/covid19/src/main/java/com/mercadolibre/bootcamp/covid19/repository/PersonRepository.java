package com.mercadolibre.bootcamp.covid19.repository;

import com.mercadolibre.bootcamp.covid19.models.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {

    private List<Person> people = new ArrayList<>();

    public List<Person> getRiskPeople(){
        return people
                .stream()
                .filter(Person::isriskPerson)
                .collect(Collectors.toList());
    }

    public void add(Person person){
        people.add(person);
    }

}
