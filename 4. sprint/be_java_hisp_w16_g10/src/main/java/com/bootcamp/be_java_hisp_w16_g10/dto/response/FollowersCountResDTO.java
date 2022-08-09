package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class FollowersCountResDTO extends UserResDTO {
    private Integer followers_count;
    public FollowersCountResDTO(Integer user_id, String user_name, Integer followers_count) {
        super(user_id, user_name);
        this.followers_count = followers_count;
    }
}
