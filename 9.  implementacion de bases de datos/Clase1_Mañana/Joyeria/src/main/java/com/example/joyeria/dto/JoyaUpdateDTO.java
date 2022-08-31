package com.example.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaUpdateDTO {
    private int id;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
