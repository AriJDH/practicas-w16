package com.meli.deportista.Repository;

import com.meli.deportista.Dto.SportDto;
import com.meli.deportista.Dto.SportPeopleDto;
import com.meli.deportista.Entity.People;
import com.meli.deportista.Entity.Sport;
import com.meli.deportista.Util.Util;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SportRepository implements ISportRepository {

    List<Sport> sports;

    public SportRepository() {
        loadData();
    }

    public void loadData() {
        sports = new ArrayList<>();
        List<People> peopleBádminton = new ArrayList<>();
        peopleBádminton.add(new People("Anggy", "Arguello", 24));
        peopleBádminton.add(new People("Arvey", "Murcia", 23));

        List<People> peopleBaloncesto = new ArrayList<>();
        peopleBaloncesto.add(new People("Pepito", "Perez", 20));
        peopleBaloncesto.add(new People("Juanito", "Juanetez", 15));

        List<People> peopleBiatlón = new ArrayList<>();
        peopleBiatlón.add(new People("Maria", "Patarroyo", 45));
        peopleBiatlón.add(new People("Fermin", "Arguello", 47));

        sports.add(new Sport("Atletismo", 1, new ArrayList<People>()));
        sports.add(new Sport("Bádminton", 2, peopleBádminton));
        sports.add(new Sport("Baloncesto", 3, peopleBaloncesto));
        sports.add(new Sport("Balonmano", 1, new ArrayList<People>()));
        sports.add(new Sport("Biatlón", 4, peopleBiatlón));
    }

    @Override
    public List<SportDto> getSports() {
        return this.sports.stream().map(p-> Util.castTo(p, SportDto.class)).collect(Collectors.toList());
    }

    @Override
    public SportDto getByName(String name) {
        Sport sport = this.sports.stream().filter(sportFilter -> sportFilter.getName().equals(name)).findFirst().orElse(null);
        return sport != null ? new SportDto(sport.getName(), sport.getLevel()): null;
    }

    @Override
    public List<SportPeopleDto> findSportsPersons() {
        List<SportPeopleDto> sportPeopleDtos = new ArrayList<>();
        for (Sport sport: sports) {
            for (People people: sport.getPeople()) {
                sportPeopleDtos.add(new SportPeopleDto(people.getName(), people.getLast_name(), sport.getName()));
            }
        }
        return sportPeopleDtos;
    }
}
