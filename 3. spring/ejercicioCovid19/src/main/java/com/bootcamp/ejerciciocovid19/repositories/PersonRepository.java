package com.bootcamp.ejerciciocovid19.repositories;


import com.bootcamp.ejerciciocovid19.entities.Person;
import com.bootcamp.ejerciciocovid19.entities.Symptom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonRepository {
    public static  List<Person> persons = new ArrayList<>();

    public static List<Person> getAllPersons() {
        List<Symptom> symptomList = SymptomRepository.getAllSymptoms();
        Person person1 = new Person(1, 24, "Jorge", "Lopez", new ArrayList<>(Arrays.asList(symptomList.get(0), symptomList.get(1))));
        Person person2 = new Person(2, 76, "Pepe", "Díaz", new ArrayList<>(Arrays.asList(symptomList.get(4), symptomList.get(10))));
        Person person3 = new Person(3, 15, "Luis", "Gomez", new ArrayList<>(Arrays.asList(symptomList.get(0), symptomList.get(3))));
        Person person4 = new Person(4, 44, "Fernando", "Alonso", new ArrayList<>(Arrays.asList(symptomList.get(0), symptomList.get(1))));
        Person person5 = new Person(5, 80, "Nelson", "Alonso", new ArrayList<>());

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);

        return persons;
    }
}
