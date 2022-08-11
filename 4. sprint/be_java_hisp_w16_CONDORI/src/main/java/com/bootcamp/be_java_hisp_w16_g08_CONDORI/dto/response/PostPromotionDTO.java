package com.bootcamp.be_java_hisp_w16_g08_CONDORI.dto.response;

import com.bootcamp.be_java_hisp_w16_g08_CONDORI.entiry.PostPromotion;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromotionDTO {
    private int userId;
    private String userName;
    private List<PromoPostDto> posts;

}
