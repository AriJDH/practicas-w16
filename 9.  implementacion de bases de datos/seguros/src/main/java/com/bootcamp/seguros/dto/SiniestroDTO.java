package com.bootcamp.seguros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class SiniestroDTO {

    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
}
