package com.bootcamp.be_java_hisp_w16_g7.service;

import org.springframework.http.HttpStatus;
import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import java.util.List;


public interface IUserService {
    HttpStatus follow(int userId, int userIdToFollow);
    HttpStatus unfollow(int userId, int userIdToUnfollow);
    RecentPostsDTO recentPost(int idUser);
    List<Post> orderByDateAsc(List<Post> postList);
    List<Post> orderByDateDes(List<Post> postList);
    ResponseUserFollowedDTO getUserFollowedList(int id, String order);

}
