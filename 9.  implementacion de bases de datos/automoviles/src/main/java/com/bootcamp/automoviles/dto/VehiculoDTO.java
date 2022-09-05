package com.bootcamp.automoviles.dto;

import com.bootcamp.automoviles.entities.Siniestros;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculoDTO {
    private Long id;
    private String patente;
    private String marca;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate anioFabricacion;
    private int cantidadRuedas;
    private List<Siniestro_DTO> siniestros;
}
