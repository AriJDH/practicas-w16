package com.example.lasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class JoyaDto {
    Long nroIdentificatorio;
    String nombre;
    String material;
    double peso;
    String particularidad;
    @JsonProperty("posee_piedra")
    boolean poseePiedra;
}
