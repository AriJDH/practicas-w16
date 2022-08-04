package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class SymptomRepository {
    private static List<Symptom> symptoms = new ArrayList<>();

    public static List<Symptom> putSymptoms(){

        symptoms.add(new Symptom("Fiebre", "001", "Bajo"));
        symptoms.add(new Symptom("Tos", "002", "Alto"));
        symptoms.add(new Symptom("Cansasio", "003", "Medio"));

        return symptoms;
    }

    public static Symptom findSymptoms(String name){

        return symptoms.stream()
                .filter(symptom -> symptom.getName().equalsIgnoreCase(name))
                .findFirst().get();
    }



}
