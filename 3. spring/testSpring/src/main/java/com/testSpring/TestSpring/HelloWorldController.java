package com.testSpring.TestSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping
    public String HelloWorld(){
        return "Hello world";
    }

    @GetMapping("/{name}")
    public String HelloName(@PathVariable String name){
        return "Hello " + name;
    }
}
