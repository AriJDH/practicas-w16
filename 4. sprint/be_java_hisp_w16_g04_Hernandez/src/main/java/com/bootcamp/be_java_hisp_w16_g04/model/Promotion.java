package com.bootcamp.be_java_hisp_w16_g04.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Promotion {

    private Integer userId;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate date;
    @NotNull(message = "product cannot be null")
    private Product product;
    @NotNull(message = "category cannot be null")
    private Integer category;
    @NotNull(message = "price cannot be null")
    private Double price;
    @NotNull(message = "has_promo cannot be null")
    private Boolean has_promo;
    @NotNull(message = "Discount cannot be null")
    private Double discount;
}
