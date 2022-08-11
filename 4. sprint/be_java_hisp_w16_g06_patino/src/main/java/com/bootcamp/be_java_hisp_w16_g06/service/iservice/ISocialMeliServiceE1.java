package com.bootcamp.be_java_hisp_w16_g06.service.iservice;

import com.bootcamp.be_java_hisp_w16_g06.dto.FollowIdDto;
import com.bootcamp.be_java_hisp_w16_g06.dto.ResponseDTO;

public interface ISocialMeliServiceE1 {
    ResponseDTO followUser(FollowIdDto followIdDto);

    ResponseDTO unFollowUser(FollowIdDto followIdDto);

    boolean findById(int userId);

}
