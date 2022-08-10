package com.bootcamp.be_java_hisp_w16_g10.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PromoPost extends Post {
    private boolean hasPromo;
    private double discount;

    public PromoPost(String id, Product product, LocalDate date, Double price, Integer category, boolean hasPromo, double discount) {
        super(id, product, date, price, category);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
