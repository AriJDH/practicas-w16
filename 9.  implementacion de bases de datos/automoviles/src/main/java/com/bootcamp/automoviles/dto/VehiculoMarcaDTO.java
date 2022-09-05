package com.bootcamp.automoviles.dto;

import lombok.*;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
@Builder
public class VehiculoMarcaDTO {
    private String patente;
    private String marca;
}
