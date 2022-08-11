package com.example.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer postId;
    private Integer userId;
    private Product product;
    private LocalDate date;
    private Integer category;
    private Double price;
    private Boolean hasPromo=false;
    private Double discount;
}
