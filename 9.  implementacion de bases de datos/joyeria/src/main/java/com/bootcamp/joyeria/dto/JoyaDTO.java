package com.bootcamp.joyeria.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JoyaDTO {
    private Integer numeroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
