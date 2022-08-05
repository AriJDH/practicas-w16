package com.mercadolibre.bootcamp.covid19.dtos;

import com.mercadolibre.bootcamp.covid19.models.Symptom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String name;
    private String lastName;
    private List<Symptom> symptoms = new ArrayList<>();
}
