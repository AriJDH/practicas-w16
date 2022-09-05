package com.bootcamp.automoviles.dto;

import com.bootcamp.automoviles.entities.Vehiculos;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiniestroDTO {
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate fechaSiniestro;
    private double perdidaEconomica;
    private VehiculoDTO vehiculos;
}
