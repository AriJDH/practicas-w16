package com.bootcamp.integrationtest.demo.controller;

import com.bootcamp.integrationtest.demo.dto.HelloDto;
import com.bootcamp.integrationtest.demo.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @Autowired
    IHelloService helloService;
    @GetMapping("/sayHello")
    public ResponseEntity<HelloDto> sayHello()
    {
        return new ResponseEntity<>(helloService.saludar(), HttpStatus.OK);
    }
    @GetMapping("/sayHello/{name}")
    public ResponseEntity<HelloDto> sayHello(@PathVariable String name)
    {
        return new ResponseEntity<>(helloService.saludarDos(name), HttpStatus.OK);
    }
}
