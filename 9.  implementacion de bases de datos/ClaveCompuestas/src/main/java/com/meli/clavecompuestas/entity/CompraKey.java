package com.meli.clavecompuestas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraKey implements Serializable {
    private Long clienteId;
    private LocalDate fecha;
    private String descripcion;
}
