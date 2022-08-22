package com.bootcamp.be_java_hisp_w16_g10.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostReqDTO {
    @NotNull(message = "El id no puede estar vacío.")
    @Min(value = 1L, message = "El id debe ser mayor a cero.")
    private Integer userId;
    @NotNull(message = "El id no puede estar vacío.")
    @Min(value = 1L, message = "El id debe ser mayor a cero.")
    private Integer idPost;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacia")
    private LocalDate date;
    @NotNull
    private @Valid ProductReqDTO product;
    @NotNull(message = "El campo no puede estar vacio")
    @Min(value = 1L, message = "El id debe ser mayor a cero.")
    private Integer category;
    @NotNull(message = "El campo no puede estar vacio.")
    @DecimalMax(value = "10000000", message = "El precio máximo por producto es 10.000.000.")
    private Double price;
}
