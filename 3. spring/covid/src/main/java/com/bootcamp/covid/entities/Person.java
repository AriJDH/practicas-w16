package com.bootcamp.covid.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    String id;
    String firstname;
    String lastname;
    int age;
}
