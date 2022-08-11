package com.example.be_java_hisp_w16_g09.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    protected int postId;
    protected User user;
    protected LocalDate date;
    protected Product product;
    protected int categoryId;
    protected double price;

    public boolean wasPublishedAfter(LocalDate aDate) {
        return date.isAfter(aDate);
    }

    public boolean isPromo() {
        return false;
    }
}
