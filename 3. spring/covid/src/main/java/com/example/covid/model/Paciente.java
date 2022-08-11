package com.bootcamp.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    Long          id;
    String        name;
    String        lastName;
    Integer       age;
    List<Symptom> symptoms;

    public boolean hasSymptoms () {
        return !this.symptoms.isEmpty();
    }

    @JsonIgnore
    public boolean isOld () {
        return age >= 60;
    }
}
