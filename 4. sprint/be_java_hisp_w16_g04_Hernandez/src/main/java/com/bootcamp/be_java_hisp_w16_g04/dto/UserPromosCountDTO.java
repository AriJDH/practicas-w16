package com.bootcamp.be_java_hisp_w16_g04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPromosCountDTO {
    private Integer userId;
    private String userName;
    private Long promo_products_count;
}
