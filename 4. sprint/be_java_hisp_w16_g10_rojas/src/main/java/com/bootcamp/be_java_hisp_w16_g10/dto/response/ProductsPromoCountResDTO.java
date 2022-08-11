package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductsPromoCountResDTO extends UserResDTO {
    private Integer promoProductsCount;
    public ProductsPromoCountResDTO(Integer userId, String userName, Integer promoProductsCount) {
        super(userId, userName);
        this.promoProductsCount = promoProductsCount;
    }
}
