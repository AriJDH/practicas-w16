package com.bootcamp.be_java_hisp_w16_g7_cardenas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FollowersSellersDTO {
    @JsonProperty("user_id")
    private int id;

    @JsonProperty("user_name")
    private String name;

    @JsonProperty("followers")
    private List<FollowersDTO> followers;

}
