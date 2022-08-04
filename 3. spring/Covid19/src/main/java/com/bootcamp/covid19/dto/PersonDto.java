package com.bootcamp.covid19.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String name;
    private String lastname;
    private Integer age;
    private String nameSymptom;
    private String nivelGravedad;

}
