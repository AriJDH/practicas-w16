package com.bootcamp.be_java_hisp_w16_g10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private String id;
    private Product product;
    private LocalDate date;
    private Double price;
    private Integer category;
}
