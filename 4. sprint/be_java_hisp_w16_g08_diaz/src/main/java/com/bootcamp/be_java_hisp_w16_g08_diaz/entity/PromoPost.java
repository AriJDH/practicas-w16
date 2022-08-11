package com.bootcamp.be_java_hisp_w16_g08_diaz.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PromoPost extends Post{
    private boolean hasPromo;
    private double discount;

    public PromoPost(int postId, User user, LocalDate date, int category, double price, Product product, boolean hasPromo, double discount) {
        super(postId, user, date, category, price, product);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}


