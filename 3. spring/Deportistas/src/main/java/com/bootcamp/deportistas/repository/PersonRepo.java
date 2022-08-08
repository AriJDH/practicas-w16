package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepo {

    private static List<Person> persons = new ArrayList<>();

    public static List<Person> getAllPersons(){

        persons.add(new Person("Pepito", "Perez", 24, SportRepo.getSportByName("Basketball")));
        persons.add(new Person("Gabriela", "Mejia", 22, SportRepo.getSportByName("Football")));
        persons.add(new Person("Luis", "Diaz", 34, null));

        return persons;

    }
}
