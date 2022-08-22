package com.meli.be_java_hisp_w16_g5.repository;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;

import java.time.LocalDate;
import java.util.List;

public interface IPostRepository {

    PostDto savePost(Post post);

    List<PostDto> getPosts();

    List<PostDto> filterByUserIdAndDate(Integer userId, LocalDate timeAgo);
}