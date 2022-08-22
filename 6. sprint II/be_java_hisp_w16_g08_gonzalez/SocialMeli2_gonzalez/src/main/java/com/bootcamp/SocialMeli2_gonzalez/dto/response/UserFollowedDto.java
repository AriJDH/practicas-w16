package com.bootcamp.SocialMeli2_gonzalez.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserFollowedDto {
    private int userId;
    private String userName;
    private List<UserBasicInfoDto> followed;
}
