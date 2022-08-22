package com.bootcamp.integrationtest.demo.service;

import com.bootcamp.integrationtest.demo.dto.HelloDto;
import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService{
    @Override
    public HelloDto saludar() {
        HelloDto helloDto = new HelloDto(1, "Hello World");
        return helloDto;
    }

    @Override
    public HelloDto saludarDos(String name) {
        HelloDto helloDto = new HelloDto(1, "Hello "+name);
        return helloDto;
    }
}
