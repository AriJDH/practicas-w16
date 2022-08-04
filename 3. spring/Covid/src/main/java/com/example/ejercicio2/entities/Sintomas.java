package com.example.ejercicio2.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Sintomas {
    private int codigo;
    private String nombre;
    private double nivelDeGravedad;

}
