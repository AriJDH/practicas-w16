package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FollowersListResDTO extends UserResDTO {
    private List<UserResDTO> followers;
    public FollowersListResDTO(Integer user_id, String user_name, List<UserResDTO> followers) {
        super(user_id, user_name);
        this.followers = followers;
    }
}
