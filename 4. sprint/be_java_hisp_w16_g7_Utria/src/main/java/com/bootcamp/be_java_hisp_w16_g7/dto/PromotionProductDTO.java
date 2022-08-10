package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionProductDTO {

    @JsonProperty("user_id")
    private int id;

    @JsonProperty("user_name")
    private String name;

    @JsonProperty("promo_products_count")
    private int count;

}
