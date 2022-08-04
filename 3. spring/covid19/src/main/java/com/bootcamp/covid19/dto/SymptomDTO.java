package com.bootcamp.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDTO {
    private int code;
    private String nombre;
    private int nivelDeGravedad;
}
