package com.bootcamp.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {
    private String nombreSintoma;
    private String nivelDeGravedad;
}
