package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoListResDTO extends UserResDTO {
    private List<PostPromoResDTO> posts;
    public PostPromoListResDTO(Integer userId, String userName, List<PostPromoResDTO> posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
