package com.mercadolibre.bootcamp.deportistas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String name;
    private String lastName;
    private int age;
    private Sport sport;

    public boolean isSportPerson(){
        return sport != null;
    }
}
