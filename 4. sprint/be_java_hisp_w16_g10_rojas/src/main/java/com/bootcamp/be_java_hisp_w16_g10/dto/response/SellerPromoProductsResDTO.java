package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SellerPromoProductsResDTO extends UserResDTO {
    private PostResDTO posts;
    public SellerPromoProductsResDTO(Integer userId, String userName, PostResDTO posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
