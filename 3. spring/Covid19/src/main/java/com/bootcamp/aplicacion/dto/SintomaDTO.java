package com.bootcamp.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {

    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;

}
