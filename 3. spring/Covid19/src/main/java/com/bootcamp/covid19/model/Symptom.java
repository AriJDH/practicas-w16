package com.bootcamp.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {

    private String name;
    private String code;
    private String nivelGravedad;


}
