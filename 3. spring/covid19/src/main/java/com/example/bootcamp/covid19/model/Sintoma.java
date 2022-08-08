package com.example.bootcamp.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
    String codigo;
    String nombre;
    String nivel_de_gravedad;
}

