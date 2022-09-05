package com.meli.clavecompuestas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDto {
    private Long clienteId;
    private LocalDate fecha;
    private String descripcion;
}
