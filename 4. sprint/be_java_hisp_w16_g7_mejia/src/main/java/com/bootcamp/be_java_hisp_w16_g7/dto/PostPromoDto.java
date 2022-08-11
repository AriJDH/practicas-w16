package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDto {

    @JsonProperty("user_id")
    private int id;

    @JsonProperty("date")
    private LocalDate creationDate;

    @JsonProperty("product")
    private ProductDTO product;

    @JsonProperty("category")
    private int category;

    @JsonProperty("price")
    private double price;

    @JsonProperty("has_promo")
    private boolean hasPromo;

    @JsonProperty("discount")
    private double discount;
}
