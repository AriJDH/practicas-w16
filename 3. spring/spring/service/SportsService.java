package com.ejerciciodate2.spring.service;

import com.ejerciciodate2.spring.domain.Sport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SportsService {
    private List<Sport> sports = new ArrayList<>();
    public void addSport(Sport sport) {
        this.sports.add(sport);
    }
    public List<Sport> getSports() {
        return this.sports;
    }
    public Sport getSportsByName(String name) {
        return this.sports.stream().filter(sport -> sport.getName().equals(name)).findFirst().get();
    }
}
