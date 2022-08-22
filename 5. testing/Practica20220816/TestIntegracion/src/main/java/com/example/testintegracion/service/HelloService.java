package com.example.testintegracion.service;

import com.example.testintegracion.dto.HelloDTO;
import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService{
    @Override
    public HelloDTO saludar() {
        HelloDTO hello = new HelloDTO(1,"Hello World");
        return hello;
    }

    @Override
    public HelloDTO saludar2(String n) {
        return new HelloDTO(1, "Hello " + n);
    }
}
