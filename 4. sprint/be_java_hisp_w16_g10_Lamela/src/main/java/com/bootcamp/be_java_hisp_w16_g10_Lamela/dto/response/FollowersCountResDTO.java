package com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowersCountResDTO extends UserResDTO {
    private Integer followersCount;
    public FollowersCountResDTO(Integer userId, String userName, Integer followersCount) {
        super(userId, userName);
        this.followersCount = followersCount;
    }
}
