package com.bootcamp.covid.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RiskPersonDTO {
    String id;
    String firstname;
    String lastname;
    int age;
    List<SymptomDTO> symptoms;
}
