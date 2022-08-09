package com.example.be_java_hisp_w16_g03.controller;

import com.example.be_java_hisp_w16_g03.service.IPostService;
import com.example.be_java_hisp_w16_g03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    IPostService service;
}
