package com.bootcamp.deportistas.repos;


import com.bootcamp.deportistas.entities.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonsRepo {

    private static List<Person> persons = new ArrayList<>();

    public List<Person> getAllPersons (){

        persons.add(new Person("Juana", "Perez", 25, new ArrayList<>(
                Arrays.asList(SportsRepo.getSport("Skate"), SportsRepo.getSport("Volleyball")))));

        persons.add(new Person("Miguel", "Martinez", 20, new ArrayList<>(
                Arrays.asList(SportsRepo.getSport("Football")))));

        persons.add(new Person("Esteban", "Ramirez", 22, new ArrayList<>(
                Arrays.asList(SportsRepo.getSport("Volleyball"),
                        SportsRepo.getSport("Football"), SportsRepo.getSport("Basketball")))));

        persons.add(new Person("Sofia", "Petrides", 21, new ArrayList<>(
                Arrays.asList(SportsRepo.getSport("Skate")))));

        return persons;
    }
}
