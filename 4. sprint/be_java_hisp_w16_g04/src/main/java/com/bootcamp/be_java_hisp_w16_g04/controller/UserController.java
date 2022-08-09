package com.bootcamp.be_java_hisp_w16_g04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("{userId}/followers/list")
    public void Followerslist(@PathVariable int userId){
    }
}
