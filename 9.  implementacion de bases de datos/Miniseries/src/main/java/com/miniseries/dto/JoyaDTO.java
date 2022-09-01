package com.miniseries.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JoyaDTO {

    private Long id;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo;
}

