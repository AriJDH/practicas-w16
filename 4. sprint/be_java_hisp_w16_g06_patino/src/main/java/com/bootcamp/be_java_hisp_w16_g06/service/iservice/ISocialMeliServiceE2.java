package com.bootcamp.be_java_hisp_w16_g06.service.iservice;

import com.bootcamp.be_java_hisp_w16_g06.dto.FollowedDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.UserDTO;

import java.util.List;

public interface ISocialMeliServiceE2 {

    List<UserDTO> findById(int userId);

    FollowersCountDTO userFollowers(Integer userId);

    public FollowedDTO userFollowed(int userId);
}
