package com.covid19.covid.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {

    private long code;
    private String name;
    private Integer severityLevel;
}
