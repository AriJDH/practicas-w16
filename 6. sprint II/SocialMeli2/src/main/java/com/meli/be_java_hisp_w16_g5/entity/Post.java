package com.meli.be_java_hisp_w16_g5.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
/**
 * Entidad con la estructura de un post
 */
public class Post {

    @NotNull(message = "El Id del usuario no debe estar vacío o nulo")
    @Min(value=1, message = "El Id del usuario debe ser mayor a cero")
    private Integer userId;

    @NotNull(message = "El Id del post no debe estar vacío o nulo")
    @Min(value=1, message = "El Id del post debe ser mayor a cero")
    private Integer postId;

    @PastOrPresent(message = "La fecha debe ser menor o igual a la fecha actual.")
    @NotNull(message = "La fecha no debe estar en blanco ni nula")
    @JsonFormat(pattern="dd-MM-yyyy")
    @JsonProperty
    private LocalDate date;

    @NotNull(message = "El producto no debe estar vacío o nulo")
    private @Valid Product product;

    @NotNull(message = "La categoría no debe estar vacío o nulo")
    private Integer category;

    @NotNull(message="El precio no debe estar vacío")
    @Max(value=10000000, message = "El precio del post debe ser como máximo de 10 millones")
    private Double price;

    private Boolean hasPromo;
    private Double discount;

}
