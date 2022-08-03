package com.bootcamp.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Sport sport;
}
