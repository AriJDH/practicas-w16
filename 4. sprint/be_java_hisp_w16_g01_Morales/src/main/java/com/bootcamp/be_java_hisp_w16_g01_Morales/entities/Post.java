package com.bootcamp.be_java_hisp_w16_g01_Morales.entities;

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
}
