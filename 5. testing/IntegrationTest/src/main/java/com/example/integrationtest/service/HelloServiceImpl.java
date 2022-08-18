package com.example.integrationtest.service;

import com.example.integrationtest.dto.HelloDTO;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public HelloDTO sayHi2(String name) {
        HelloDTO helloDTO = new HelloDTO(1, "Hello "+name+"!");
        return helloDTO;
    }

    @Override
    public HelloDTO sayHi() {
        HelloDTO helloDTO = new HelloDTO(1, "Hello World!");
        return helloDTO;
    }
}
