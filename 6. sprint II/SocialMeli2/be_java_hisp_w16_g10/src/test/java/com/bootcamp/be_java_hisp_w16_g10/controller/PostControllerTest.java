package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.ProductReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.service.IPostService;
import com.bootcamp.be_java_hisp_w16_g10.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static com.bootcamp.be_java_hisp_w16_g10.util.Factory.generateProductReqDTO;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @Mock
    private PostService postService;
    @InjectMocks
    private PostController postController;

    @Test
    @DisplayName("shouldSavePostReqDTO")
    void US005() {
        //arrange
        PostReqDTO postReqDTO = generateProductReqDTO();

        //act
        var response = postController.US005(postReqDTO);

        //assert
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void US006() {
    }

}