package com.myapp.deportista.services;

import com.myapp.deportista.dtos.AthleteDTO;
import com.myapp.deportista.dtos.SportDTO;
import com.myapp.deportista.entities.Athlete;
import com.myapp.deportista.entities.Person;
import com.myapp.deportista.entities.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportService {
    private final List<Sport> listsports = new ArrayList<>();
    private final List<Person> listpeople = new ArrayList<>();

    private final List<Athlete> listAthete = new ArrayList<>();

    public SportService() {
        Sport s1 = Sport.builder().name("Baloncesto").level("1").build();
        Sport s2 = Sport.builder().name("Tenis").level("2").build();
        Sport s3 = Sport.builder().name("Paracaidismo").level("extremo").build();

        listsports.add(s1);
        listsports.add(s2);
        listsports.add(s3);

        Person p1=Person.builder().firstName("John").lastName("Doe").build();
        Person p2=Person.builder().firstName("Juan").lastName("Doe").build();
        Person p3=Person.builder().firstName("Sergio").lastName("Doe").build();
        Person p4=Person.builder().firstName("J").lastName("Doe").build();

        listpeople.add(p1);
        listpeople.add(p2);
        listpeople.add(p3);
        listpeople.add(p4);

        Athlete a1 = Athlete.builder().person(p2).sport(s1).build();
        Athlete a2 = Athlete.builder().person(p3).sport(s2).build();
        Athlete a3 = Athlete.builder().person(p4).sport(s1).build();

        listAthete.add(a1);
        listAthete.add(a2);
        listAthete.add(a3);

    }

    public List<SportDTO> getAllSports(){
        return listsports.stream()
                .map(sport -> {
                    SportDTO sportDTO = new SportDTO();
                    sportDTO.setName(sport.getName());
                    sportDTO.setLevel(sport.getLevel());
                    return sportDTO;
                }).collect(Collectors.toList());
    }

    public SportDTO getSport(String name){
        Sport sport=listsports.stream()
               .filter(s->s.getName().equals(name))
               .findFirst()
                .orElse(null);
        if (sport == null){
            return null;
        }
        SportDTO sportDTO = new SportDTO();
        sportDTO.setName(sport.getName());
        sportDTO.setLevel(sport.getLevel());
        return sportDTO;
    }

    public List<AthleteDTO> findAthlete(){
        return listAthete.stream()
                .map(athlete -> {
                    AthleteDTO athleteDTO = new AthleteDTO();
                    athleteDTO.setNamePerson(athlete.getPerson().getFirstName());
                    athleteDTO.setLastNamePerson(athlete.getPerson().getLastName());
                    athleteDTO.setSport(athlete.getSport().getName());

                    return athleteDTO;
                }).collect(Collectors.toList());

    }

}
