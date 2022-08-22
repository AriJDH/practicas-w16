package com.example.be_java_hisp_w16_g03.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
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

    public void increaseId() {
        this.postId = lastId++;
    }

}
