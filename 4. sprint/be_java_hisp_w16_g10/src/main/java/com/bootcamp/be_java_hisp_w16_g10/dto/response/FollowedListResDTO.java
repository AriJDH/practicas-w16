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
public class FollowedListResDTO extends UserResDTO {
    private List<UserResDTO> followed;
    public FollowedListResDTO(Integer user_id, String user_name, List<UserResDTO> followed) {
        super(user_id, user_name);
        this.followed = followed;
    }
}
