package com.example.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Sintoma {
    private int codigo;
    private String nombre;
    private  String nivelGravedad;

}
