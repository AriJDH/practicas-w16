package com.example.ejcovid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Sintoma {
    private int codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
