package com.bootcamp.be_java_hisp_w16_g01_rodriguez.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostDTO extends PostDTO{

    private boolean hasPromo;
    private double discount;

    public PromoPostDTO(int userId, LocalDate date, ProductDTO product, int category, double price, boolean hasPromo, double discount) {
        super(userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PostDTO onlyDataPostDTO(){
        return new PostDTO(
                this.getUserId(),
                this.getDate(),
                this.getProduct(),
                this.getCategory(),
                this.getPrice()
        );
    }
}