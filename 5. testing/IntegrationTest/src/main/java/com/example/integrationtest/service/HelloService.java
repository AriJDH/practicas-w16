package com.example.integrationtest.service;

import com.example.integrationtest.dto.HelloDTO;

public interface HelloService {
    HelloDTO sayHi();

    HelloDTO sayHi2(String name);
}
