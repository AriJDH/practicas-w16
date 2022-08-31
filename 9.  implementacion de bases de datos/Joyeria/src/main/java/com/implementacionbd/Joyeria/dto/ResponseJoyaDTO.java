package com.implementacionbd.Joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter@Getter
@AllArgsConstructor

public class ResponseJoyaDTO {
    private Long id;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean poseePriedra;
    private boolean ventaONo;
}
