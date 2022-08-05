package com.mercadolibre.bootcamp.covid19.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {
    private int id;
    private String name;
    private String levelOfSeverity;
}
