package com.bootcamp.covidapi.models;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona implements Serializable {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Sintoma> sintomas;
}
