package com.example.integrationtest.controller;

import com.example.integrationtest.dto.HelloDTO;
import com.example.integrationtest.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @Autowired
    HelloService helloService;

    @GetMapping("/sayHelloWorld")
    public ResponseEntity<HelloDTO> helloEnd(){
        return new ResponseEntity<>(helloService.sayHi(), HttpStatus.OK);
    }

    @GetMapping("/sayHello/{name}")
    public ResponseEntity<HelloDTO> helloEnd(@PathVariable String name){
        return new ResponseEntity<>(helloService.sayHi2(name), HttpStatus.OK);
    }
}
