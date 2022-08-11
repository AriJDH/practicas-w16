package com.bootcamp.be_java_hisp_w16_g08_CONDORI.entiry;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromotion extends Post {
    private boolean hasPromo;
    private double discount;

    public PostPromotion(int postPromoIdCount, User postUser, LocalDate date, int category, double price, boolean hasPromo, double discount, Product asociatedProduct) {
        super(postPromoIdCount, postUser, date, category, price, asociatedProduct);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
