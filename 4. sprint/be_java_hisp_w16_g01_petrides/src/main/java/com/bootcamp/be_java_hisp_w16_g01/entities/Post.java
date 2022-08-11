package com.bootcamp.be_java_hisp_w16_g01.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int postId;
    private int userId;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Post(int postId, int userId, LocalDate date, Product product, int category, double price) {
        this.postId = postId;
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public Post(int userId, LocalDate date, Product product, int category, double price) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public Post(int userId, LocalDate date, Product product, int category, double price, boolean hasPromo,
                double discount) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
