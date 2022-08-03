package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepo {

    public static List<Person> personList = new ArrayList<>();

    public static List<Person> getAllPersons(){
        return personList;
    }
}
