package com.bootcamp.be_java_hisp_w16_g10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer id;
    private Integer userId;
    private Product product;
    private LocalDate date;
    private Double price;
    private Integer category;
    private Boolean hasPromo;
    private Double discount;
}
