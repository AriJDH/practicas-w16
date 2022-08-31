package com.implementacionbd.Joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class JoyaDTO {

    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean poseePriedra;
    private boolean ventaONo;
}
