package com.bootcamp.SocialMeli2.service;

import com.bootcamp.SocialMeli2.dto.RequestPostDTO;
import com.bootcamp.SocialMeli2.dto.ResponsePostDTO;

public interface IPostService {

    void createPost(RequestPostDTO requestPostDTO);

    ResponsePostDTO getAllPost(int userId);

    ResponsePostDTO getAllPost(int userId, String Order);

}
