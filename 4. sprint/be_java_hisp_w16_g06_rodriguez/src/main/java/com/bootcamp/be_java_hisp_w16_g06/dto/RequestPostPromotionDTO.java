package com.bootcamp.be_java_hisp_w16_g06.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestPostPromotionDTO {

    private int user_id;
    private String date;
    private ProductDTO product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;


}
