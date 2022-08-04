package com.bootcamp.practico.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Person {

    private int id;
    private String name;
    private String lastname;
    private int age;
    private List<Symptom> symptom;
}
