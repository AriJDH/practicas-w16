package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    PostService postService;



}
