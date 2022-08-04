package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class PersonRepository {

    private static List<Person> people = new ArrayList<>();

    public static List<Person> putPeople(){

        people.add(new Person("12432", "Andres", "Roa", 22, SymptomRepository.findSymptoms("Fiebre")));
        people.add(new Person("342", "Silena", "Dangond", 31, SymptomRepository.findSymptoms("Tos")));
        people.add(new Person("124221", "Johan", "Sanchez", 26, SymptomRepository.findSymptoms("Cansasio")));
        people.add(new Person("124221", "Evelin", "Sanchez", 70, SymptomRepository.findSymptoms("Cansasio")));


        return people;
    }

}
