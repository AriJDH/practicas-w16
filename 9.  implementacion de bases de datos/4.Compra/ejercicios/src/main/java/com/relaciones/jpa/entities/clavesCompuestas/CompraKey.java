package com.relaciones.jpa.entities.clavesCompuestas;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode//OJO IMPORTANTE ESTOS MÉTODOS
public class CompraKey implements Serializable {
    private Long clienteId;
    private LocalDate fecha;
}
