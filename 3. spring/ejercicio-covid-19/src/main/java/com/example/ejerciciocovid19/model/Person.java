package com.example.ejerciciocovid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Person {

    private final UUID id;
    private final String name, surname;
    private final Integer age;
    private final List<Symptom> symptoms;


}
