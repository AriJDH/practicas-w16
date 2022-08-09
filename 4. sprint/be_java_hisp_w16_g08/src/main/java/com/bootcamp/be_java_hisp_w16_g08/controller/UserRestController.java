package com.bootcamp.be_java_hisp_w16_g08.controller;

import com.bootcamp.be_java_hisp_w16_g08.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    IUserService userService;


    //comentario testeo
}
