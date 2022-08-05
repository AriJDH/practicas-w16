package com.mercadolibre.bootcamp.covid19.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDto {
    private String name;
    private String levelOfSeverity;
}
