package com.bootcamp.be_java_hisp_w16_g7_cardenas.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponseUserFollowedDTO {
    private int userId;
    private String userName;
    private List<ResponseUserDTO> followed;
}
