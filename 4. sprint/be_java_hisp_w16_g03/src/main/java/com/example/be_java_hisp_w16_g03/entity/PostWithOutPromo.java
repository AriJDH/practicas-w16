package com.example.be_java_hisp_w16_g03.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class PostWithOutPromo extends Post {


    public PostWithOutPromo(Integer userId, LocalDate date, Double price, Product product, Integer category) {
        super(userId, date, price, product, category);
    }

    @Override
    public void increaseId() {
        this.postId = this.lastId++;
    }
}
