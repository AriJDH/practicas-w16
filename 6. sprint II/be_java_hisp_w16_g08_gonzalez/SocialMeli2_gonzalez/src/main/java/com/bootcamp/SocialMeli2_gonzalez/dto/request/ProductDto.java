package com.bootcamp.SocialMeli2_gonzalez.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDto {

    @NotNull(message = "El  id no puede estar vacía")
    @Min(value = 1,message = "El id debe ser mayor a cero")
    private int productId;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(min=1,max=40,message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp="[a-zA-Z\\s]*",message="El campo no puede poseer caracteres especiales.")
    private String productName;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(min=1,max=15,message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp="[a-zA-Z\\s]*",message="El campo no puede poseer caracteres especiales.")
    private String type;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(min=1,max=25,message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp="[a-zA-Z\\s]*",message="El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(min=1,max=15,message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp="[a-zA-Z\\s]*",message="El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(min=0,max=80,message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp="[a-zA-Z\\s]*",message="El campo no puede poseer caracteres especiales.")
    private String notes;
}