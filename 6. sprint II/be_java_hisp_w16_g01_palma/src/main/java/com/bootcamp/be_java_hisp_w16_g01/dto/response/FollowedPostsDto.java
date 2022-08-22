package com.bootcamp.be_java_hisp_w16_g01.dto.response;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.ResponsePostDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowedPostsDto {

    private int userId;

    private List<ResponsePostDto> posts;
}
