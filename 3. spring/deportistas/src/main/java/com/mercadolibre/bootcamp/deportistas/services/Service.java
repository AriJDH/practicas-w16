package com.mercadolibre.bootcamp.deportistas.services;

import com.mercadolibre.bootcamp.deportistas.domain.Person;
import com.mercadolibre.bootcamp.deportistas.domain.Sport;
import com.mercadolibre.bootcamp.deportistas.dtos.PersonDto;
import com.mercadolibre.bootcamp.deportistas.dtos.SportDto;
import com.mercadolibre.bootcamp.deportistas.repositories.PersonRepository;
import com.mercadolibre.bootcamp.deportistas.repositories.SportsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {
    PersonRepository personRepository = new PersonRepository();
    SportsRepository sportsRepository = new SportsRepository();

    private Service(){
        super();
    };

    private static Service instance;

    public static Service getInstance() {
        if(instance == null)
            instance = new Service();
        return instance;
    }

    public void initilizeData() {
        Sport sport1 = new Sport("Futbol", "3");
        Sport sport2 = new Sport("Natacion", "2");

        personRepository.addNew(new Person("Javi", "Gomez", 25, sport1));
        personRepository.addNew(new Person("Ricardito", "Perez", 22, sport2));

        sportsRepository.addNew(sport1);
        sportsRepository.addNew(sport2);
    }

    public List<SportDto> getAllSports() {
        List<Sport> sports = sportsRepository.getAll();
        return sports
                .stream()
                .map(sport -> new SportDto(sport.getName()))
                .collect(Collectors.toList());
    }

    public Sport searchByName(String name) {
        Optional<Sport> sport = sportsRepository.searchByName(name);
        if(sport.isPresent())
            return sport.get();
        else
            return null;
    }

    public List<PersonDto> getAllSportsman(){
        List <Person> sportmans = personRepository.getOnlySportmans();
        return sportmans
                .stream()
                .map(person -> new PersonDto(person))
                .collect(Collectors.toList());

    }


}
