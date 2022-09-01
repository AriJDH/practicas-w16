package com.example.joyerialasperlas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewJoyaDto {

    private String nombre;
    private String material;
    private double peso ;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
