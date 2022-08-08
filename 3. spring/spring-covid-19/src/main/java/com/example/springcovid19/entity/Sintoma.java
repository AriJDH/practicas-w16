package com.example.springcovid19.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
    private int codigo;
    private String nombre;
    private double nivelDeGravedad;
}
