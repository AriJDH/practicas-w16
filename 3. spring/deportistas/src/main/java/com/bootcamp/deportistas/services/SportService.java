package com.bootcamp.deportistas.services;

import com.bootcamp.deportistas.dtos.AthleticPersonDto;
import com.bootcamp.deportistas.dtos.SportDTO;
import com.bootcamp.deportistas.entities.Person;
import com.bootcamp.deportistas.entities.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportService {

    private final List<Sport> sports = new ArrayList<>();
    private final List<Person> people = new ArrayList<>();

    public SportService() {
        Sport s1 = Sport.builder().name("Baloncesto").level("1").build();
        Sport s2 = Sport.builder().name("Tenis").level("2").build();
        Sport s3 = Sport.builder().name("Paracaidismo").level("extremo").build();

        sports.add(s1);
        sports.add(s2);
        sports.add(s3);

        people.add(Person.builder().firstName("John").lastName("Doe").build());
        people.add(Person.builder().firstName("Juan").lastName("Doe").sport(s1).build());
        people.add(Person.builder().firstName("Sergio").lastName("Doe").sport(s2).build());
        people.add(Person.builder().firstName("J").lastName("Doe").sport(s3).build());

    }

    public List<SportDTO> getAllSports() {
        return sports.stream().map(sport -> {
            SportDTO sportDto = new SportDTO();
            sportDto.setLevel(sport.getLevel());
            sportDto.setName(sport.getName());
            return sportDto;
        }).collect(Collectors.toList());
    }

    public SportDTO getSport(String name) {
        Sport sport =  sports.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if(sport == null)
            return null;

        SportDTO sportDto = new SportDTO();
        sportDto.setName(sport.getName());
        sportDto.setLevel(sport.getLevel());
        return sportDto;
    }

    public List<AthleticPersonDto> findSportsPeople() {
        return people.stream()
                .filter(person -> person.getSport() != null)
                .map(person -> {
                    AthleticPersonDto personDto = new AthleticPersonDto();
                    personDto.setFirstName(person.getFirstName());
                    personDto.setLastName(person.getLastName());
                    personDto.setSport(person.getSport().getName());
                    return personDto;
                }).collect(Collectors.toList());
    }
}
