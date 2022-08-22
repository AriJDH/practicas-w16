package com.bootcamp.be_java_hisp_w16_g06.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPostDTO {

    @Min(value = 1, message = "El id debe ser mayor a cero")
    private int user_id;
    @NotEmpty(message = "La fecha no puede estar vacía.")
    private String date;
    @Valid
    private ProductDTO product;
    @NotNull(message = "El campo no puede estar vacío.")
    private int category;
    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private double price;

}
