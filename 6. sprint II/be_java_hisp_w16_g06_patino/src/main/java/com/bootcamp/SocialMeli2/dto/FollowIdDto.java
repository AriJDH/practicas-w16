package com.bootcamp.SocialMeli2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowIdDto {
    private int userId;
    private int userIdToFollow;
}
