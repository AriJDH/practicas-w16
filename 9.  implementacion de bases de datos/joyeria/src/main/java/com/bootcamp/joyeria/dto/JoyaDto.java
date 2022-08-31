package com.bootcamp.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class JoyaDto {
    @NotEmpty(message = "El campo no puede estar vacío.")
    private String nombre;
    @NotEmpty(message = "El campo no puede estar vacío.")
    private String material;
    @Min(message = "El peso es requerido", value = 1)
    private Integer peso;
    @NotEmpty(message = "El campo no puede estar vacío.")
    private String particularidad;
    @NotEmpty(message = "El campo no puede estar vacío.")
    private Boolean posee_piedra;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @AssertTrue(message = "Para crearlo debe ser verdadero")
    private Boolean ventaONo;
}
