package com.meli.be_java_hisp_w16_g5.repository;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;

import java.util.Date;
import java.util.List;

public interface IPostRepository {

    PostDto savePost(Post post);
    List<PostDto> getPosts();
    List<PostDto> filterByUserIdAndDate(int userId, Date timeAgo, Integer sortCondition);
}