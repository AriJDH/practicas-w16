package com.bootcamp.automoviles.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculoSiniestroDTO {
    private VehiculoMarcaDTO vehiculo;
    private double perdida;
}
