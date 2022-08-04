package com.bootcamp.ejerciciocovid19.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private int age;
    private String name;
    private String lastname;
    private List<Symptom> symptomList;
}
