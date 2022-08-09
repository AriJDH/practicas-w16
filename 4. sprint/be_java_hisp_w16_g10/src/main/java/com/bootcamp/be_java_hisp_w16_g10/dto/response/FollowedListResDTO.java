package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FollowedListResDTO extends UserResDTO {
    private List<UserResDTO> followed;
}
