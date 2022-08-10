package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class FollowersDTO {
    @JsonProperty("userId")
    private int id;

    @JsonProperty("userName")
    private String name;
}
