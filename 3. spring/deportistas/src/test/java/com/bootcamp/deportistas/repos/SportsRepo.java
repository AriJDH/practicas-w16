package com.bootcamp.deportistas.repos;

import com.bootcamp.deportistas.entities.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportsRepo {

    private static List<Sport> sports = new ArrayList<>();

    public static List<Sport> getAllSports(){

        sports.add(new Sport("Basketball", "Advance" ));
        sports.add(new Sport("Football", "Medium"));
        sports.add(new Sport("Volleyball", "Beginner"));
        sports.add(new Sport("Baseball", "Advance" ));
        sports.add(new Sport("Skate", "Medium" ));

        return sports;
    }

    public static Sport getSport(String name){
        return sports.stream().filter(sport -> sport.getName().equals(name)).findFirst().get();
    }
}
