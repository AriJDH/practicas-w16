package com.myapp.covid.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

}
