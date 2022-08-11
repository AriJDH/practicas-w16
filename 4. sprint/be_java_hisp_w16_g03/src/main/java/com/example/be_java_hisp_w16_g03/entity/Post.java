package com.example.be_java_hisp_w16_g03.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class Post {

    protected static int lastId;
    protected Integer userId;
    protected Integer postId;
    protected LocalDate date;
    protected Product product;
    protected Integer category;
    protected Double price;

    public Post(Integer userId, LocalDate date, Double price, Product product, Integer category) {
        this.userId = userId;
        this.date = date;
        this.price = price;
        this.product = product;
        this.category = category;
    }

    public abstract void increaseId();

}
