package com.example.ejerciciocovid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Symptom {

    private final UUID code;
    private final String name;
    private Integer gravityLevel;

}
