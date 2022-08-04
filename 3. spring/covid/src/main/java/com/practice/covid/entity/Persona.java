package com.practice.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private int id;
    private  String name;
    private String lastName;
    private int age;
    private List<Sintoma> sintomaList;
}
