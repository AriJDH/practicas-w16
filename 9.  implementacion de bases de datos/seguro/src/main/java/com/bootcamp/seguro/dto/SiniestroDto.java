package com.bootcamp.seguro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SiniestroDto {
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    @JsonIgnoreProperties("siniestros")
    private VehiculoDto vehiculoDenunciado;
}
