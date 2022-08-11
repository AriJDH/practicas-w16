package com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoResDTO extends PostResDTO {
    private Boolean hasPromo;
    private Double discount;
    PostPromoResDTO(Integer userId, Integer postId, LocalDate date, ProductResDTO product, Integer category, Double price, Boolean hasPromo, Double discount) {
        super(userId, postId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
