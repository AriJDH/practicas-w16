package com.bootcamp.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String id;
    private String name;
    private String lastName;
    private int age;
    private List<Symptom> symptomList;
}
