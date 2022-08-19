package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDTO {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("user_name")
    private String userName;
}
