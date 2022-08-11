package com.bootcamp.be_java_hisp_w16_g08.dto.request;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.ProductDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostDto extends PostDto{
    private boolean hasPromo;
    private double discount;

    public PromoPostDto(int userId, LocalDate date, ProductDto product, int category, double price, boolean hasPromo, double discount) {
        super(userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

}
