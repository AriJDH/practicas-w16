package com.bootcamp.SocialMeli2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private int product_id;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Length(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "El campo no puede poseer caracteres especiales.")
    private String product_name;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Length(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "El campo no puede poseer caracteres especiales.")
    private String type;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Length(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "El campo no puede poseer caracteres especiales.")
    private String brand;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Length(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "El campo no puede poseer caracteres especiales.")
    private String color;
    @Length(max = 80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "El campo no puede poseer caracteres especiales.")
    private String notes;

}
