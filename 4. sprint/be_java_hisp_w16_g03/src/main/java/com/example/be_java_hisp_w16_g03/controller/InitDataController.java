package com.example.be_java_hisp_w16_g03.controller;

import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.service.ICreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InitDataController {
    @Autowired
    ICreateService service;
    @PostMapping("/createUser")
    public ResponseEntity<List<UserDTO>> createUser(@RequestBody List<UserDTO> userdto){
       return new ResponseEntity<>(service.postData(userdto), HttpStatus.CREATED);
    }
}
