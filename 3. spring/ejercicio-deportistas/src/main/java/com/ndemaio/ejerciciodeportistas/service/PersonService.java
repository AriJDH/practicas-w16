package com.ndemaio.ejerciciodeportistas.service;

import com.ndemaio.ejerciciodeportistas.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final List<Person> personList;

    public PersonService() {
        this.personList = new ArrayList<>();
    }

    public List<Person> getSportsPeople() {
        return personList;
    }
}
