package com.spring.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;

}
