package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoProductCountResDTO extends UserResDTO{
    private int promoProductCount;

    public PromoProductCountResDTO(Integer userId, String userName, int promoProductCount) {
        super(userId, userName);
        this.promoProductCount = promoProductCount;
    }
}
