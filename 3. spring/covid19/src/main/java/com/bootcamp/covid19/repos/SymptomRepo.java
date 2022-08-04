package com.bootcamp.covid19.repos;

import com.bootcamp.covid19.entities.Symptom;

import java.util.ArrayList;
import java.util.List;

public class SymptomRepo {

    private static List<Symptom> symptoms = new ArrayList<>();

    public static List<Symptom> getSymptoms(){

        symptoms.add(new Symptom(1, "Dolor de garganta", 2));
        symptoms.add(new Symptom(2, "Dolor de cabeza", 1));
        symptoms.add(new Symptom(3, "Falta de aire", 4));
        symptoms.add(new Symptom(4, "Fiebre", 3));

        return symptoms;
    }

    public static Symptom getSymptom(String symptomName){
        return symptoms.stream().filter(x-> x.getName().equals(symptomName)).findFirst().get();
    }

    public static Symptom getSymptom(int code){
        return symptoms.stream().filter(x-> x.getCode()==code).findFirst().get();
    }
}
