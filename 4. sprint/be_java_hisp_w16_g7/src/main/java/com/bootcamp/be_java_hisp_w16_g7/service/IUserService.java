package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersCountDto;

public interface IUserService {
    public FollowersCountDto getFollowersCount(int id);
}
