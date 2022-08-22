package com.bootcamp.be_java_hisp_w16_g10.unit.controller;

import static com.bootcamp.be_java_hisp_w16_g10.util.Factory.generateProductReqDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.bootcamp.be_java_hisp_w16_g10.controller.PostController;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.service.PostService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {
    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    @Test
    void shouldReturnListFollowersPost() {

        // arrange
        Optional<String> opt = Optional.empty();
        PostListResDTO postListResDTO = new PostListResDTO(1, List.of());

        // act
        when(postService.listFollowersPosts(postListResDTO.getUserId(), "date_desc")).thenReturn(postListResDTO);
        ResponseEntity<PostListResDTO> resController = postController.US006(postListResDTO.getUserId(), opt);

        // assert
        verify(postService, atLeastOnce()).listFollowersPosts(postListResDTO.getUserId(), "date_desc");
        assertEquals(resController, new ResponseEntity<>(postListResDTO, HttpStatus.OK));

    }

    @Test
    void shouldSavePostReqDTO() {
        //arrange
        PostReqDTO postReqDTO = generateProductReqDTO();

        //act
        var response = postController.US005(postReqDTO);
        verify(postService).save(postReqDTO);

        //assert
        assertEquals(200, response.getStatusCodeValue());
    }

}
