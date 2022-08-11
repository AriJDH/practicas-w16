package com.meli.be_java_hisp_w16_g5.repository;


import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PromoDiscountDto;
import com.meli.be_java_hisp_w16_g5.dto.PromoProductsCounts;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.User;

import java.util.Date;
import java.util.List;

public interface IUserRepository {


    public User findUserById(int useriD);

    public void setUserFollowSeller(int userIdToFollow, int userId);
    public void setUserFollowersSeller(int userId, int userIdToFollow);

    PostDto savePost(Post post);
    PromoDiscountDto savePostDiscount(Post post);


    List<PostDto> filterByUserIdAndDate(Date date, Integer sortCondition);
}
