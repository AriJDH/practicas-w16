package com.example.be_java_hisp_w16_g03.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private static int lastId;
    private Integer userId;
    private Integer postId;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private boolean hasPromo;
    private double discount;

    public void increaseId() {
        this.postId = lastId++;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", postId=" + postId +
                ", date=" + date +
                ", product=" + product +
                ", category=" + category +
                ", price=" + price +
                ", hasPromo=" + hasPromo +
                ", discount=" + discount +
                '}';
    }
}
