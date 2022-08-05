package com.myapp.covid.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private String person_firstName;
    private String person_lastName;
    private Integer age;
    private List<String> symptoms_names;
}
