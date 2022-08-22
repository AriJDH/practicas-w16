package com.meli.be_java_hisp_w16_g5.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@EqualsAndHashCode
/**
 * Entidad con la estructura de un product
 */
public class Product {

    @NotNull(message = "El Id del producto no debe estar vacío")
    @Min(value = 1, message = "El Id del producto debe ser mayor a cero")
    private Integer productId;

    @NotBlank(message = "El nombre del producto no puede estar en blanco")
    @NotEmpty(message = "El nombre del producto no debe ser nulo")
    @Size(max=40, message = "El nombre del producto debe contener como máximp 40 caracteres")
    @Pattern(regexp="^([A-z0-9]+([ ]+[A-z0-9]+)*)$", message = "El nombre del producto no debe tener caracteres especiales.")
    private String productName;

    @NotBlank(message = "El tipo del producto no debe tener espacios en blanco")
    @NotEmpty(message = "El tipo del producto no debe estar vacío o nulo")
    @Size(max=15, message = "El tipo del producto debe contener como máximp 15 caracteres")
    @Pattern(regexp="^([A-z0-9]+([ ]+[A-z0-9]+)*)$", message = "El tipo del producto no debe tener caracteres especiales.")
    private String type;

    @NotEmpty(message = "La marca del producto no debe estar vacío o nulo")
    @NotBlank(message = "La marca del producto no debe tener espacios en blanco")
    @Size(max=25, message = "La marca del producto debe contener como máximp 25 caracteres")
    @Pattern(regexp="^([A-z0-9]+([ ]+[A-z0-9]+)*)$", message = "La marca del producto no debe tener caracteres especiales.")
    private String brand;

    @NotEmpty(message = "El color del producto no debe estar vacío o nulo")
    @Size(max=15, message = "El color del producto debe contener como máximp 15 caracteres")
    @Pattern(regexp="^([A-z0-9]+([ ]+[A-z0-9]+)*)$", message = "El color del producto no debe tener caracteres especiales.")
    private String color;

    @Size(max=80, message = "Las notas del producto deben contener como máximp 80 caracteres")
    @Pattern(regexp="^([A-z0-9]+([ ]+[A-z0-9]+)*)$", message = "Las notas del producto no debe tener caracteres especiales.")
    private String notes;

}
