package com.bootcamp.be_java_hisp_w16_g7.controller;

import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersSellersDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/{userId}/followers/list")
    public FollowersSellersDTO getSellersFollowers(@PathVariable int userId){
      return userService.getSellersFollowers(userId);
    }
}
