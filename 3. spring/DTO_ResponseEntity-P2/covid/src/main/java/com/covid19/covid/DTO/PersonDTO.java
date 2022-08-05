package com.covid19.covid.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private String name;
    private String lastname;
    private int age;
    private List<SymptomDTO> symptoms;

}
