package com.example.ejercicioCovid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {

    private int codigo;
    private String nombre;
    private int nivel_de_gravedad;
}
