package com.example.ejerciciocovid19.repository;

import com.example.ejerciciocovid19.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonRepository {

    private final List<Person> personList;

    public PersonRepository() {
        personList = new ArrayList<>();
    }

    public List<Person> getAll() {
        return personList;
    }
}
