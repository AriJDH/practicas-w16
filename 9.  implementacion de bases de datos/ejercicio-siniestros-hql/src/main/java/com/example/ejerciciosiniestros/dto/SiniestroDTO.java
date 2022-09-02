package com.example.ejerciciosiniestros.dto;

import com.example.ejerciciosiniestros.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroDTO {
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    private Long vehiculoId;
}
