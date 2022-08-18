package com.bootcamp.be_java_hisp_w16_g10.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductReqDTO {
    @NotNull(message = "El id no puede estar vacío.")
    @Min(value = 1L, message = "El id debe ser mayor a cero.")
    private Integer productId;
    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    //El espacio es importante
    @Pattern(regexp = "[A-ZÀ-Úa-zà-ú\\d ]*", message = "El nombre del producto no debe contener caracteres especiales.")
    private String productName;
    @NotBlank(message = "El campo no puede estar vacio.")
    @Pattern(regexp = "[A-ZÀ-Úa-zà-ú\\d ]*", message = "El nombre del tipo no debe contener caracteres especiales.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    private String type;
    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "[A-ZÀ-Úa-zà-ú\\d ]*", message = "El nombre del tipo no debe contener caracteres especiales.")
    private String brand;
    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[A-ZÀ-Úa-zà-ú\\d ]*", message = "El color no debe contener caracteres especiales.")
    private String color;
    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "[A-ZÀ-Úa-zà-ú\\d ]*", message = "El campo no debe contener caracteres especiales.")
    private String notes;
}
