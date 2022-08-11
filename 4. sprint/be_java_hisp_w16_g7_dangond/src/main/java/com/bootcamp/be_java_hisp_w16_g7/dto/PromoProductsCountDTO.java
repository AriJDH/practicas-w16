package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoProductsCountDTO {

    @JsonProperty("user_id")
    private int id;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("promo_products_count")
    private int promoProductsCount;

}
