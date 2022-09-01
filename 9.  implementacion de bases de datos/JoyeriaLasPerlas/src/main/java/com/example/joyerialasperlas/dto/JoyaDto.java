package com.example.joyerialasperlas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDto {
    private long nro_identificatorio;
    private String nombre;
    private String material;
    private double peso ;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
