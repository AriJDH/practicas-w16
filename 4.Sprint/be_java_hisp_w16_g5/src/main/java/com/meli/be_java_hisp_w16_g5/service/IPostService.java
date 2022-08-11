package com.meli.be_java_hisp_w16_g5.service;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PostPromoDto;
import com.meli.be_java_hisp_w16_g5.dto.PostsByUserDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.exceptions.ProducNotFoundException;
import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;

import java.util.List;

public interface IPostService {

    PostDto save(Post post) throws UserNotFoundException, ProducNotFoundException;

    PostPromoDto savePromo(Post post) throws UserNotFoundException, ProducNotFoundException;
    List<PostDto> getPosts();
    PostsByUserDto getFollowedProducts(int userId, String order) throws UserNotFoundException, UnknownRequestException;
}