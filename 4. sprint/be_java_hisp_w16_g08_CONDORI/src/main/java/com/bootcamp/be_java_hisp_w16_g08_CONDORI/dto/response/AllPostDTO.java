package com.bootcamp.be_java_hisp_w16_g08_CONDORI.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AllPostDTO {
    private int userId;
    private String userName;
    private List<PromoPostDto> postsPromotions;
    private List<ResponsePostDto> posts;

}
