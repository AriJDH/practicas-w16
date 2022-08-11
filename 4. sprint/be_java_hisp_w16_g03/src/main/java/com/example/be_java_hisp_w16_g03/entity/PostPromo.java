package com.example.be_java_hisp_w16_g03.entity;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class PostPromo extends Post {

    private Boolean hasPromo;
    private Double discount;

    public PostPromo(Integer userId, LocalDate date, Double price, Product product, Integer category, Boolean hasPromo, Double discount) {
        super(userId, date, price, product, category);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }


    @Override
    public void increaseId() {
        this.postId = this.lastId++;
    }
}
