package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserFollowers;

public interface IUserService {
    UserFollowers getVendorsFollowedByUser(int userId);
    UserFollowers getAllFollowers(int id);
}
