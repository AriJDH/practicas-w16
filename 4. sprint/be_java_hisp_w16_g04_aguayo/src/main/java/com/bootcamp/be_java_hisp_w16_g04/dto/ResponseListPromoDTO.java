package com.bootcamp.be_java_hisp_w16_g04.dto;

import java.util.List;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponseListPromoDTO {

    private Integer userId;
    private String userName;
    List<PostDTO> posts;
}
