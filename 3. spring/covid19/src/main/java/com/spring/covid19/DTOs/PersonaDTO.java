package com.spring.covid19.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<SintomaDTO> listaSintomas;

}
