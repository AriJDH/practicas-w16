package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoListResDTO {
    private Integer userId;
    private String userName;
    private List<PostPromoResDTO> posts;
}
