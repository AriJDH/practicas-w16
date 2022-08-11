package com.example.be_java_hisp_w16_g09.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Post {

    private int postId;
    private User user;
    private LocalDate date;
    private Product product;
    private int categoryId;
    private double price;
    private boolean hasPromo;
    private double discount;

    public boolean wasPublishedAfter(LocalDate aDate) {
        return date.isAfter(aDate);
    }
    public Post(int postId, User user, LocalDate date, Product product, int categoryId, double price){
        this.postId = postId;
        this.user = user;
        this.date = date;
        this.product = product;
        this.categoryId = categoryId;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0;
    }

    public Post(int postId, User user, LocalDate date, Product product, int categoryId, double price, boolean hasPromo, double discount) {
        this.postId = postId;
        this.user = user;
        this.date = date;
        this.product = product;
        this.categoryId = categoryId;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
    public Post(){

    };
}
