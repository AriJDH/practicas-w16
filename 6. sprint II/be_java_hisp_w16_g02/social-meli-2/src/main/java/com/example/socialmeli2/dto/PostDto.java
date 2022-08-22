package com.example.socialmeli2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDto {
    @NotNull(message = "El id no puede ser vacío.")
    @Min(value = 1, message = "El id debe ser mayor a 0.")
    private int userId;

    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonFormat(pattern="dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    @Valid
    @JsonFormat
    private ProductDto product;

    @NotNull(message = "El campo no puede estar vacío.")
    private int category;

    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMax(value = "10000000.0", message = "El precio máximo por producto es de 10000000.0")
    private double price;
}
