package com.bootcamp.covid19.repos;

import com.bootcamp.covid19.entities.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonRepo {

    private static List<Person> persons = new ArrayList<>();

    public static List<Person> getPersons(){

        persons.add(new Person(1,"Juan", "Perez", 20, new ArrayList<>(Arrays.asList(1,3))));
        persons.add(new Person(1,"Margarita", "Rios", 65, new ArrayList<>(Arrays.asList(1,3,4))));
        persons.add(new Person(1,"Roberto", "Diaz", 70, new ArrayList<>()));
        persons.add(new Person(1,"Sofia", "Petrides", 27, new ArrayList<>(Arrays.asList(1))));
        persons.add(new Person(1,"Enrique", "Martinez", 83, new ArrayList<>(Arrays.asList(1,4))));

        return persons;
    }



}
