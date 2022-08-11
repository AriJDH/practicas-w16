package com.bootcamp.be_java_hisp_w16_g04.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@EqualsAndHashCode(callSuper = true)
public class ResponseNumberPromoProductsDTO extends UserDTO{
    private Integer promoProductsCount;
    public ResponseNumberPromoProductsDTO(Integer userId, String userName, Integer promoProductsCount){
        super(userId,userName);
        this.promoProductsCount = promoProductsCount;

    }
}
