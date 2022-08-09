package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;

import java.util.List;

public interface IProductService {
    RecentPostsDTO recentPost(int idUser);
    List<Post> orderByDateAsc(List<Post> postList);
    List<Post> orderByDateDes(List<Post> postList);
}
