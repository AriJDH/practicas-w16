package com.bootcamp.be_java_hisp_w16_g7_espitia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponseUserDTO {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("user_name")
    private String userName;
}
