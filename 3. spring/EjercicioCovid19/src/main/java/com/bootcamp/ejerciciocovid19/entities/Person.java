package com.bootcamp.ejerciciocovid19.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    private Integer id;
    private String name;
    private String subName;
    private Integer age;

}
