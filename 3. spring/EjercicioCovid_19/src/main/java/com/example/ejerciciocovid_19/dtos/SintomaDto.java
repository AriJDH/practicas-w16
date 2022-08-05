package com.example.ejerciciocovid_19.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDto {
    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
