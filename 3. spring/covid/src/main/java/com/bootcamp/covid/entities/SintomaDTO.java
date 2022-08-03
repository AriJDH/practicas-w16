package com.bootcamp.covid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDTO {
    private String nombre;
    private String nivelDeGravedad;
}
