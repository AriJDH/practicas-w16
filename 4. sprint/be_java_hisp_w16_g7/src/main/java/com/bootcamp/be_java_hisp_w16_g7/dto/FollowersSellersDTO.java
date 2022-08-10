package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FollowersSellersDTO{
    @JsonProperty("userId")
    private int id;

    @JsonProperty("userName")
    private String name;

    @JsonProperty("followers")
    private List<FollowersDTO> followers;

}
