package com.bootcamp.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {

    private String code;
    private String name;
    private String severityLevel;

}
