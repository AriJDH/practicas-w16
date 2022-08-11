package com.bootcamp.be_java_hisp_w16_g01.dto;

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
public class ResponsePromoPostDTO extends ResponsePostDto {
    private boolean hasPromo;
    private double discount;

    public ResponsePromoPostDTO(int userId, int postId, LocalDate date, ProductDto product, int category, double price, boolean hasPromo, double discount) {
        super(userId, postId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
