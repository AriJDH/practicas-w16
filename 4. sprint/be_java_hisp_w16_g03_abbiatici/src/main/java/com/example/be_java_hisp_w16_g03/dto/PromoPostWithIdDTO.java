package com.example.be_java_hisp_w16_g03.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromoPostWithIdDTO {
    private Integer userId;
    private Integer postId;
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;
    private boolean hasPromo;
    private Double discount;
}
