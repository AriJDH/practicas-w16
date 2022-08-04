package com.bootcamp.covid19.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Person {

    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private Symptom symptom;


}
