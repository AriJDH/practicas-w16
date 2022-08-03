package com.bootcamp.ejercicioDeportistas.services;

import com.bootcamp.ejercicioDeportistas.dtos.SportDto;
import com.bootcamp.ejercicioDeportistas.dtos.SportPersonsDto;
import com.bootcamp.ejercicioDeportistas.entities.Persons;
import com.bootcamp.ejercicioDeportistas.entities.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceSport {
  List<Sport> sports = new ArrayList<>();
  List<SportPersonsDto> sportPersons = new ArrayList<>();

  public List<SportDto> getAllSports() {
    return sports.stream().map(sport -> new SportDto(sport.getName(), sport.getLevel())).collect(Collectors.toList());
  }

  public SportDto getSport(String name) {
    Sport sport = sports.stream().filter(sp -> sp.getName().equals(name)).findFirst().get();
    return new SportDto(sport.getName(), sport.getLevel());
  }

  public SportPersonsDto getSportPersons(String name) {
    return sportPersons.stream().filter(person -> person.getName().equals(name)).findFirst().get();
  }

  public void completarLista() {
    Sport futbol = new Sport("Futbol", 8);
    Sport voley = new Sport("Voley", 9);
    Sport atletismo = new Sport("Atletismo", 10);
    sports.add(futbol);
    sports.add(voley);
    sports.add(atletismo);
    sports.add(new Sport("Tenis", 7));
    sports.add(new Sport("Natacion", 6));
    sportPersons.add(new SportPersonsDto("Juanito", "Gomez", futbol));
    sportPersons.add(new SportPersonsDto("Angela", "Guzman", voley));
    sportPersons.add(new SportPersonsDto("Angela", "Guzman", atletismo));
  }

  public ServiceSport() {
    completarLista();
  }
}
