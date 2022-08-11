package com.meli.be_java_hisp_w16_g5.repository;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PostPromoDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;

import java.time.LocalDate;
import java.util.List;

public interface IPostRepository {

    PostDto savePost(Post post);
    PostPromoDto savePostPromo(Post post);
    List<PostDto> getPosts();
    List<PostPromoDto> getPostsPromo();
    List<PostDto> filterByUserIdAndDate(int userId, LocalDate timeAgo);
}