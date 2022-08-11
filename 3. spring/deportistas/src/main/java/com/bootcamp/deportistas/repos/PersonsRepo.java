package com.bootcamp.deportistas.repos;

import com.bootcamp.deportistas.entities.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonsRepo {
    private static List<Person> persons = new ArrayList<>();

    public static List<Person> getAllPersons(){

        persons.add(new Person("Juan", "Perez", 24, new ArrayList<>(Arrays.asList(
                SportsRepo.getSport("Basketball"), SportsRepo.getSport("Football")))));

        persons.add(new Person("Sofia", "Rodriguez", 22, new ArrayList<>(Arrays.asList(
                SportsRepo.getSport("Skate"), SportsRepo.getSport("Volleyball")))));

        persons.add(new Person("Luis", "Suarez", 34, new ArrayList<>(Arrays.asList(
                SportsRepo.getSport("Football")))));

        persons.add(new Person("Pablo", "Diaz", 25, new ArrayList<>(Arrays.asList(
                SportsRepo.getSport("Skate"), SportsRepo.getSport("Baseball")))));

        return persons;

    }
}
