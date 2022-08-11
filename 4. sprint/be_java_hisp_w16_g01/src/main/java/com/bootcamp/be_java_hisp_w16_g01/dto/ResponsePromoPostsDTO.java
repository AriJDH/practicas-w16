package com.bootcamp.be_java_hisp_w16_g01.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponsePromoPostsDTO extends FollowedPostsDto {
    public ResponsePromoPostsDTO(int userId, List<ResponsePostDto> posts) {
        super(userId, posts);
    }
}
