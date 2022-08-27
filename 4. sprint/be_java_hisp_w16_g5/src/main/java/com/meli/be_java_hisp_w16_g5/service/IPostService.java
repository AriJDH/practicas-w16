package com.meli.be_java_hisp_w16_g5.service;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PostsByUserDto;
import com.meli.be_java_hisp_w16_g5.dto.PromoDiscountDto;
import com.meli.be_java_hisp_w16_g5.dto.PromoProductsCounts;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.exceptions.NoPostException;
import com.meli.be_java_hisp_w16_g5.exceptions.ProducNotFoundException;
import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;

import java.util.List;

public interface IPostService {

    PostDto save(Post post) throws UserNotFoundException, ProducNotFoundException;
    PromoDiscountDto savePostDiscount(Post post) throws UserNotFoundException, ProducNotFoundException;
    PromoProductsCounts getPostDiscountCount(int id) throws UserNotFoundException, NoPostException;
    List<PostDto> getPosts();
    PostsByUserDto getFollowedProducts(int userId, String order) throws UserNotFoundException, UnknownRequestException;
}