package com.meli.be_java_hisp_w16_g5.repository;


import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface IUserRepository {


    public User findUserById(int useriD);

    public void setUserFollowSeller(int userIdToFollow, int userId);
    public void setUserFollowersSeller(int userId, int userIdToFollow);

    PostDto savePost(Post post);

    List<PostDto> filterByUserIdAndDate(LocalDate date, Integer sortCondition);
}
