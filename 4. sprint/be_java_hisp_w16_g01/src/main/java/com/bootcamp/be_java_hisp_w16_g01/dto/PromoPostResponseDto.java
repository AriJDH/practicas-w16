package com.bootcamp.be_java_hisp_w16_g01.dto;

import com.bootcamp.be_java_hisp_w16_g01.entities.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostResponseDto {
    private int postId;
    private int userId;
    private LocalDate date;
    private ProductDto product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
