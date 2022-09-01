package com.example.joyas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class JoyaDto {
    @JsonProperty("nro_identificatorio")
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;
    private Boolean ventaONo;

    public JoyaDto(String nombre, String material, Double peso, String particularidad, Boolean posee_piedra, Boolean ventaONo) {
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.poseePiedra = posee_piedra;
        this.ventaONo = ventaONo;
    }
}
