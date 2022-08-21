package com.bootcamp.SocialMeli2.service;

import com.bootcamp.SocialMeli2.dto.FollowIdDto;
import com.bootcamp.SocialMeli2.dto.ResponseDTO;

public interface IFollowUnFollowService {
    ResponseDTO followUser(FollowIdDto followIdDto);

    ResponseDTO unFollowUser(FollowIdDto followIdDto);

    boolean existUser(int userId);

}
