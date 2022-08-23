package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    @JsonProperty("user_id")
    @NotNull(message = "El id del usuario no puede estar vacío.")
    @Positive(message = "El id del usuario debe ser mayo a cero.")
    private Integer id;

    @JsonProperty("date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate creationDate;

    @JsonProperty("product")
    @Valid
    private ProductDTO product;

    @JsonProperty("category")
    @NotNull(message = "El id de la categoria no puede estar vacío.")
    @Positive(message = "El id de la categoria debe ser en valores positivos.")
    private Integer category;

    @JsonProperty("price")
    @NotNull(message = "El precio no puede estar vacío.")
    @DecimalMax(value = "10000000.0", message = "El valor máximo del producto es de 10 millones de pesos.")
    @DecimalMin(value = "1.0", message = "El valor mínimo del producto es de 1 peso.")
    private Double price;

}
