package com.bootcamp.be_java_hisp_w16_g06.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPostDTO extends RequestPromoPostDTO {

    private int user_id;
    private String date;
    private ProductDTO product;
    private int category;
    private double price;

}
