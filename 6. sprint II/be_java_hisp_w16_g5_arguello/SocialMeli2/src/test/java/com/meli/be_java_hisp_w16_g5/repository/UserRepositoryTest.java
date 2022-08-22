package com.meli.be_java_hisp_w16_g5.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.User;
import com.meli.be_java_hisp_w16_g5.util.Util;
import com.meli.be_java_hisp_w16_g5.util.UtilTestTools;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
    
    @InjectMocks
    private UserRepository userRepository;

    @Test
    public void filterByUserIdAndDate(){
        //Arrange
        User user = UtilTestTools.createUser("Jhon", 100);
        LocalDate date = Util.timeAgo(2);
        String order = "date_asc";
        String tag = "date";
        Integer sortCondition = Util.getSortCondition(order, tag);

        List<Post> posts = UtilTestTools.getListProductsForUser(user, 100);
        List<PostDto> expectedPosts =  posts.stream().filter(post ->
            post.getUserId() == user.getUserId()
            && 
            post.getDate().compareTo(date) >= 0
            )    
            .map(p-> Util.castTo(p, PostDto.class))
            .collect(Collectors.toList()
        );

        user.setPosts(new ArrayList<>());
        List<User> users = List.of(user);
        userRepository.save(users);

        for(int i = 0; i < posts.size(); i++){
            Post post = posts.get(i);
            userRepository.savePost(post);
        }

        expectedPosts.sort((PostDto p1, PostDto p2) -> p1.getDate().compareTo(p2.getDate()) * sortCondition);

        //Act

        List<PostDto> filteredPosts = userRepository.filterByUserIdAndDate(date, Util.getSortCondition(order, tag));

        //Assert
        assertTrue(UtilTestTools.areEquals(expectedPosts, filteredPosts, PostDto.class, "getPostId"));
    }
}
