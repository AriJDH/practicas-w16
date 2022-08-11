package com.bootcamp.sport.services;

import com.bootcamp.sport.entity.PersonDTO;
import com.bootcamp.sport.entity.SportDTO;
import com.bootcamp.sport.entity.SportsDTO;
import com.bootcamp.sport.models.Person;
import com.bootcamp.sport.models.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportPersonService {
    private List<Person> persons;
    private List<Sport> sports;

    private void initializeRepo() {
        this.sports.add(new Sport("Futbol", "Alto"));
        this.sports.add(new Sport("Running", "Alto"));
        this.sports.add(new Sport("Tenis", "Alto"));

        this.persons.add(new Person("Pepe", "Lopez", this.sports.get(0)));
        this.persons.add(new Person("Pepa", "Lopez", this.sports.get(1)));
        this.persons.add(new Person("Pepa", "Pig", this.sports.get(2)));
    }

    public SportPersonService() {
        this.persons = new ArrayList<>();
        this.sports = new ArrayList<>();
        this.initializeRepo();
    }

    public SportsDTO findAllSports() {
        return new SportsDTO(this.sports);
    }

    public SportDTO findSport(String sportName) {
        return new SportDTO(this.sports.stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(sportName))
                .findFirst()
                .get()
                .getLevel()
        );
    }

    public List<PersonDTO> findAllPersons(){
        return this.persons.stream()
                .map(person -> new PersonDTO(person.getFirstName(), person.getLastName(), person.getSport().getName()))
                .collect(Collectors.toList());
    }
}
