package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowersListResDTO extends UserResDTO {
    private List<UserResDTO> followers;
    public FollowersListResDTO(Integer userId, String userName, List<UserResDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }
}
