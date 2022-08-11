package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostCountDTO {

    @JsonProperty("user_id")
    private int id;

    @JsonProperty("user_name")
    private String name;

    @JsonProperty("promo_products_count")
    private int promoProductsCount;
}

