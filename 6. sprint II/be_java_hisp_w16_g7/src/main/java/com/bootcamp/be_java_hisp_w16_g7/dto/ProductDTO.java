package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    @JsonProperty("product_id")
    @NotNull(message = "El id del producto no puede estar vacío.")
    @Positive(message = "El id del producto debe ser mayo a cero.")
    private Integer productId;

    @JsonProperty("product_name")
    @NotBlank(message = "El nombre del producto no puede estar vacío.")
    @Size(max = 40, message = "La longitud del nombre del producto no puede superar los 40 caracteres.")
    @Pattern(regexp="[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del producto no puede poseer caracteres especiales.")
    private String productName;

    @JsonProperty("type")
    @NotBlank(message = "El tipo de producto no puede estar vacío.")
    @Size(max = 15, message = "La longitud del tipo de producto no puede superar los 15 caracteres.")
    @Pattern(regexp="[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El tipo del producto no puede poseer caracteres especiales.")
    private String type;

    @JsonProperty("brand")
    @NotBlank(message = "La marca no puede estar vacío.")
    @Size(max = 25, message = "La longitud del nombre de la marca no puede superar los 25 caracteres.")
    @Pattern(regexp="[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "La marca no puede poseer caracteres especiales.")
    private String brand;

    @JsonProperty("color")
    @NotBlank(message = "El color no puede estar vacío.")
    @Size(max = 15, message = "La longitud del color no puede superar los 15 caracteres.")
    @Pattern(regexp="[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El color no puede poseer caracteres especiales.")
    private String color;

    @JsonProperty("notes")
    @Size(max = 80, message = "La longitud de las notas no pueden superar los 80 caracteres.")
    @Pattern(regexp="[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "Las notas no pueden poseer caracteres especiales.")
    private String notes;

}
