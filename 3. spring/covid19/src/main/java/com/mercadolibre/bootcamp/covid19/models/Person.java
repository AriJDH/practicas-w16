package com.mercadolibre.bootcamp.covid19.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;
    private String name;
    private String lastName;
    private int age;
    private List<Symptom> symptoms = new ArrayList<>();

    public boolean hasSymptoms () {
        return !this.symptoms.isEmpty();
    }

    public boolean isOld () {
        return age >= 60;
    }

    public boolean isriskPerson(){
        return hasSymptoms() && isOld();
    }


}


