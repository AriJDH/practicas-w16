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
    private LocalDate creationDate;
    private Product product;
    private Category category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
