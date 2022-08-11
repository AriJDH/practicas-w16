package com.bootcamp.covid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {
    String code;
    String name;
    String severityLevel;

}
