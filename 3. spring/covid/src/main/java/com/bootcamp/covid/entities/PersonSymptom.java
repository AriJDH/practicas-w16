package com.bootcamp.covid.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonSymptom {
    private Person person;
    private Symptom symptom;
}
