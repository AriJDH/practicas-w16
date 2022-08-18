package com.bootcamp.SocialMeli2.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDto {

    @NotNull(message = "El  id no puede estar vacío")
    @Min(value = 1,message = "El id debe ser mayor a cero")
    private int userId;

    @NotNull(message = "La fecha no puede estar vacía")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    @Valid
    private ProductDto product;

    @NotNull(message = "El campo no puede estar vacío")
    private int category;

    @NotNull(message = "El campo no puede estar vacío")
    @Max(value = 10000000,message = "El precio máximo por producto es de 10.000.000")
    private double price;


}
