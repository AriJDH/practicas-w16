package com.bootcamp.lasperlas.dto.request;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JoyaDTO {
  private String nombre;
  private String material;
  private Double peso;
  private String particularidad;
  private Boolean poseePiedra;
  private Boolean venta;
}
