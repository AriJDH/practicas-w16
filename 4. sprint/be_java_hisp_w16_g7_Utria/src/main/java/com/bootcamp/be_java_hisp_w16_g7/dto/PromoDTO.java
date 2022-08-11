package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
public class PromoDTO {

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

    public PromoDTO(int id, LocalDate creationDate, ProductDTO product, int category, double price, double discount) {
        this.id = id;
        this.creationDate = creationDate;
        this.product = product;
        this.category = category;
        this.price = price;
        this.discount = discount;
    }
}
