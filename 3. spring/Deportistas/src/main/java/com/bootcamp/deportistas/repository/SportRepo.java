package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.entities.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportRepo {

    private static List<Sport> sports = new ArrayList<>();

    public static List<Sport> getAllSports(){

        sports.add(new Sport("Basketball", "Advance" ));
        sports.add(new Sport("Football", "Medium"));

        return sports;
    }

    public static Sport getSportByName(String name){
        return sports.stream().filter(sport -> sport.getName().equals(name)).findFirst().get();
    }

}
