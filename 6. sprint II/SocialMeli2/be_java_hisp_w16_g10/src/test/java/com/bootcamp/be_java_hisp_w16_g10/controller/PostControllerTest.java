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
        ProductReqDTO productReqDTO = new ProductReqDTO(1, "Mac", "Compu", "Apple", "Gris","nada");
        PostReqDTO postReqDTO = new PostReqDTO(1,1, LocalDate.now(),productReqDTO,10,1500.0);

        var response = postController.US005(postReqDTO);

        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void US006() {
    }

}