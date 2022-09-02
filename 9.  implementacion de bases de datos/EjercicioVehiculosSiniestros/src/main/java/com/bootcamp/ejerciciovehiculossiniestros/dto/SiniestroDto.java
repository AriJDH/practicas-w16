package com.bootcamp.ejerciciovehiculossiniestros.dto;

import com.bootcamp.ejerciciovehiculossiniestros.model.Vehiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SiniestroDto {
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate fechaSiniestro;
    private Double perdida;

    private String patente;
}
