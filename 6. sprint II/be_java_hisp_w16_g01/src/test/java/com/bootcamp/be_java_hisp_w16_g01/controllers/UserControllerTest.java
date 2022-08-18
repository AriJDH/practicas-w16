package com.bootcamp.be_java_hisp_w16_g01.controllers;

import com.bootcamp.be_java_hisp_w16_g01.controller.UserController;
import com.bootcamp.be_java_hisp_w16_g01.service.IUserService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    IUserService userService;

    @InjectMocks
    UserController userController;
}
