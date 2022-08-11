package com.bootcamp.be_java_hisp_w16_g06.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountPromotionDTO {

    private  int user_id;
    private String user_name;
    private int promo_products_count;

}
