package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.entities.Symptom;

import java.util.ArrayList;
import java.util.List;

public class SymptomRepo {

    public static List<Symptom> symptomList = new ArrayList<>();

    public static List<Symptom> getAllSymptons(){
        return symptomList;
    }

    public static Symptom getSymptomByName(String name){
       return symptomList.stream().filter(symptom -> symptom.getName().equalsIgnoreCase(name)).findFirst().get();

    }
}
