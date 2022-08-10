package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoCountResDTO extends UserResDTO{
    private Integer promosCount;

    public PromoCountResDTO(Integer userId, String userName, Integer promosCount) {
        super(userId, userName);
        this.promosCount = promosCount;
    }
}
