package com.spring.covid19.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {

    private Integer codigo;
    private String nombre;
    private Integer nivel_de_gravedad;

}
