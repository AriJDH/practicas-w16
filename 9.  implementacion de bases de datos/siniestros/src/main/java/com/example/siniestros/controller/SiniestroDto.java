package com.example.siniestros.controller;


import com.example.siniestros.dto.VehiculoDto;
import com.example.siniestros.model.Vehiculo;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SiniestroDto {

    private LocalDate fecha;
    private Double perdidaEconomica;
    private VehiculoDto vehiculoDenunciado;
}
