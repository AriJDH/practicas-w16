package com.bootcamp.aplication.controller;

import com.bootcamp.aplication.DTO.PersonSportDTO;
import com.bootcamp.aplication.DTO.SportsDTO;
import com.bootcamp.aplication.Entity.Person;
import com.bootcamp.aplication.Entity.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class DeportistasController {

    @GetMapping("/findSports")
    private ResponseEntity<List<SportsDTO>> findSports() {

        return new ResponseEntity<>(findSport(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    private ResponseEntity<SportsDTO> findSportsByName(@PathVariable String name) {

        SportsDTO sportByName = new SportsDTO("not Found", "not Found");

        findSport().stream()
                .forEach(data -> {
                    if (data.getNombre().toUpperCase().equals(name.toUpperCase())) {
                        sportByName.setNombre(data.getNombre());
                        sportByName.setNivel(data.getNivel());
                    }
                });

        return new ResponseEntity<>(sportByName, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    private ResponseEntity<List<PersonSportDTO>> findSportsPersons() {

        List<PersonSportDTO> personSportDTOList = new ArrayList<>();

        preloadSportsAndPerson().stream()
                .forEach(x -> {
                    if (!x.getSport().getNombre().isEmpty()) {
                        personSportDTOList.add(new PersonSportDTO(
                                x.getNombre(),
                                x.getApellido(),
                                x.getSport().getNombre()));
                    }
                });

        return new ResponseEntity<>(personSportDTOList, HttpStatus.OK);
    }

    public List<SportsDTO> findSport() {
        List<SportsDTO> sportsDTOList = new ArrayList<>();

        for (Person p : preloadSportsAndPerson()) {
            String name = p.getSport().getNombre();
            String level = p.getSport().getNivel();

            if (sportsDTOList == null || sportsDTOList.isEmpty()) {
                sportsDTOList.add(new SportsDTO(name, level));
            }

            sportsDTOList.add(new SportsDTO(name, level));
        }

        Set<SportsDTO> sportsDTOSet = sportsDTOList.stream()
                .filter(data1 -> !data1.getNombre().isEmpty())
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(SportsDTO::getNombre))
                ));

        sportsDTOList = sportsDTOSet.stream()
                .sorted(Comparator.comparing(SportsDTO::getNombre))
                .collect(Collectors.toList());
        return sportsDTOList;
    }

    public List<Person> preloadSportsAndPerson() {

        List<Sport> sportsList = new ArrayList<>();

        Sport sportAny = new Sport("", "");

        Sport football = new Sport("Football", "Advanced");
        sportsList.add(football);
        Sport volleyball = new Sport("Volleyball", "Advanced");
        sportsList.add(volleyball);
        Sport cycling = new Sport("Cycling", "Middle");
        sportsList.add(cycling);
        Sport swimming = new Sport("Swimming", "Easy");
        sportsList.add(swimming);
        Sport hiking = new Sport("Hiking", "Easy");
        sportsList.add(hiking);

        List<Person> personList = new ArrayList<>();

        Person person1 = new Person("Daniel", "Martinez", 18, football);
        personList.add(person1);
        Person person2 = new Person("Tomas", "Patino", 38, sportAny);
        personList.add(person2);
        Person person3 = new Person("Juliana", "Vargas", 22, volleyball);
        personList.add(person3);
        Person person4 = new Person("Aldo", "Hurtado", 28, sportAny);
        personList.add(person4);
        Person person5 = new Person("Maria", "Sepulveda", 39, cycling);
        personList.add(person5);
        Person person6 = new Person("Marcos", "Garcia", 16, swimming);
        personList.add(person6);
        Person person7 = new Person("Ernesto", "Rojas", 25, sportAny);
        personList.add(person7);
        Person person8 = new Person("Juan", "Marin", 32, hiking);
        personList.add(person8);

        return personList;
    }
}
