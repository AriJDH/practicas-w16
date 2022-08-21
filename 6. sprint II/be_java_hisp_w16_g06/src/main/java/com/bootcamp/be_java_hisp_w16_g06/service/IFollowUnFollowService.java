package com.bootcamp.be_java_hisp_w16_g06.service;

import com.bootcamp.be_java_hisp_w16_g06.dto.FollowIdDto;
import com.bootcamp.be_java_hisp_w16_g06.dto.ResponseDTO;

public interface IFollowUnFollowService {
    ResponseDTO followUser(FollowIdDto followIdDto);

    ResponseDTO unFollowUser(FollowIdDto followIdDto);

    boolean existUser(int userId);

}
