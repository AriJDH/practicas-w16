package com.example.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {

    private String codigo;
    private String nombre;
    private Integer nivel_de_gravedad;

}
