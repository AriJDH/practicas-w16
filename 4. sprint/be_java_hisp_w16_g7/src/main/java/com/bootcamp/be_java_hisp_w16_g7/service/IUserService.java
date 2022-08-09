package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;

import java.util.List;

public interface IUserService {

    ResponseUserFollowedDTO getUserFollowedList(int id, String order);

}
