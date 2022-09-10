package com.bootcamp.covid.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RiesgoDTO {

    private String nombre;
    private String apellido;
    private int edad;
    List<SintomaDTO> sintomaDTOList;
}
