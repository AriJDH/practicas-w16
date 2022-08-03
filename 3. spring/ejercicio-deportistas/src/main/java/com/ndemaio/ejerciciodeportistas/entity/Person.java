package com.ndemaio.ejerciciodeportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person {

    private final String name, surname;
    private final Integer age;
    private final Sport sport;

}
