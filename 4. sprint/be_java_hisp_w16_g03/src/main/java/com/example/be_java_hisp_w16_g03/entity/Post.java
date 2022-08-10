package com.example.be_java_hisp_w16_g03.entity;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Integer userId;
    private Integer postId;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private static int lastId;

    public void increaseId(){
        this.postId = lastId++;
    }

}
