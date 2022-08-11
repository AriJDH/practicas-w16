package com.example.be_java_hisp_w16_g03.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer productId;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private String productName;
    private Boolean has_promo;
    private Double discount;
}
