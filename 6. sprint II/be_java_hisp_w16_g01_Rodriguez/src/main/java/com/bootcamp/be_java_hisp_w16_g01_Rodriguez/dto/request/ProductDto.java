package com.bootcamp.be_java_hisp_w16_g01_Rodriguez.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDto {

    @NotNull(message = "El campo no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero.")
    private Integer productId;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9äöüÄÖÜáéíóúÁÉÍÓÚ\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    private String productName;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9äöüÄÖÜáéíóúÁÉÍÓÚ\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9äöüÄÖÜáéíóúÁÉÍÓÚ\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9äöüÄÖÜáéíóúÁÉÍÓÚ\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9äöüÄÖÜáéíóúÁÉÍÓÚ\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
