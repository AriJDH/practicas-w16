package com.example.be_java_hisp_w16_g03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostWithIdDTO {

    @NotNull(message = "El id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a 0")
    private Integer userId;

    @NotNull(message = "El id_post no puede estar vacío")
    @Positive(message = "El id_post debe ser mayor a cero")
    private Integer postId;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull(message = "La fecha no puede estar vacía")
    private LocalDate date;

    @Valid
    private ProductDTO product;

    @NotNull(message = "El campo no puede estar vacío")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío")
    @Max(value = 10000000, message = "El precio maximo por producto es de 10.000.000")
    private Double price;
}
