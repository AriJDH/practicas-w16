package com.example.socialmeli2.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDto {
    @NotNull(message = "El id no puede ser vacío.")
    @Min(value = 1, message = "El id debe ser mayor a 0.")
    private Integer productId;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "El campo no puede poseer caracteres especiales.")
    private String productName;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
