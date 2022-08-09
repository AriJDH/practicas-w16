package com.ejerciciodate2.spring.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String name;
    private String lastName;
    private Integer age;
    private List<Sport> sports;
    private boolean isSportsman;
}
