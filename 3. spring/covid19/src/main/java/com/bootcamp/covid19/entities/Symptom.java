package com.bootcamp.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {
    private int code;
    private String name;
    private int severityLevel;
}
