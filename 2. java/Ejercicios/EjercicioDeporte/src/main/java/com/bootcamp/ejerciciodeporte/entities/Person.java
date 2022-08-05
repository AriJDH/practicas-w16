package com.bootcamp.ejerciciodeporte.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    private String name;
    private String subName;
    private int age;
    private Sport sport;
}
