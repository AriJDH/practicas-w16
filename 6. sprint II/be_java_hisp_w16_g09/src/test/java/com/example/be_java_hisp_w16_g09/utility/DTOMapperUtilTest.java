package com.example.be_java_hisp_w16_g09.utility;

import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.model.Post;
import com.example.be_java_hisp_w16_g09.model.Product;
import com.example.be_java_hisp_w16_g09.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class DTOMapperUtilTest {

    @Test
    void shouldMapASingleObjectCorrectly () {
        var date = LocalDate.now();
        User user = Mockito.mock(User.class);
        Mockito.when(user.getUserId()).thenReturn(1);

        Post postToMap = new Post(1, user, date, new Product(), 1, 1);

        DTOMapperUtil dtoMapperUtil = new DTOMapperUtil();

        PostDto mappedObject = dtoMapperUtil.map(postToMap, PostDto.class);

        assertThat(mappedObject.getUserId()).isEqualTo(postToMap.getUser().getUserId());
        assertThat(mappedObject.getDate()).isEqualTo(postToMap.getDate());
        assertThat(mappedObject.getPostId()).isEqualTo(postToMap.getPostId());
    }

}
