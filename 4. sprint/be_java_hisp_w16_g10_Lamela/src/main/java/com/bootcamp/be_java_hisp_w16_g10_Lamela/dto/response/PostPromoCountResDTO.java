package com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoCountResDTO {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;
}
