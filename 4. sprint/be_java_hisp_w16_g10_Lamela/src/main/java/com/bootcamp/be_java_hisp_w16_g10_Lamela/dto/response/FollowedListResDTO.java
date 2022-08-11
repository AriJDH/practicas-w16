package com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowedListResDTO extends UserResDTO {
    private List<UserResDTO> followed;
    public FollowedListResDTO(Integer userId, String userName, List<UserResDTO> followed) {
        super(userId, userName);
        this.followed = followed;
    }
}
