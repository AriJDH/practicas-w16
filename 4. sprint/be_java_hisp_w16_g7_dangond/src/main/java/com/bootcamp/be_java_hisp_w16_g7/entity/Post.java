package com.bootcamp.be_java_hisp_w16_g7.entity;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int id;
    private int postId;
    private LocalDate creationDate;
    private Product product;
    private int category;
    private double price;
    private Boolean hasPromo;
    private double discount;
}
